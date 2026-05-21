package analyzer;

import java.util.*;

public class CodeParser {

    public static class ParseResult {
        public int classCount = 0;
        public int methodCount = 0;
        public int commentLines = 0;
        public int blankLines = 0;
        public int totalLines = 0;

        // NEW
        public int cyclomaticComplexity = 0;
    }

    public static ParseResult analyze(List<String> lines) {

        ParseResult result = new ParseResult();
        result.totalLines = lines.size();

        boolean inBlockComment = false;

        for (String line : lines) {

            String trimmed = line.trim();

            // blank line
            if (trimmed.isEmpty()) {
                result.blankLines++;
                continue;
            }

            // block comment start
            if (trimmed.startsWith("/*")) {
                inBlockComment = true;
                result.commentLines++;
                continue;
            }

            // block comment end
            if (trimmed.endsWith("*/")) {
                inBlockComment = false;
                result.commentLines++;
                continue;
            }

            if (inBlockComment) {
                result.commentLines++;
                continue;
            }

            // single line comment
            if (trimmed.startsWith("//")) {
                result.commentLines++;
                continue;
            }

            // class detection
            if (trimmed.contains("class ")) {
                result.classCount++;
            }

            // method detection
            if (isMethodLine(trimmed)) {
                result.methodCount++;
            }

            // cyclomatic complexity
            result.cyclomaticComplexity += calculateLineComplexity(trimmed);
        }

        return result;
    }

    private static boolean isMethodLine(String line) {

        if (line.contains("class ")) return false;

        return line.contains("(")
                && line.contains(")")
                && line.contains("{")
                && (line.contains("public")
                || line.contains("private")
                || line.contains("protected")
                || line.contains("static"));
    }

    // Cyclomatic Complexity logic
    private static int calculateLineComplexity(String line) {

        int complexity = 0;

        if (line.contains(" if ")) complexity++;
        if (line.contains("for")) complexity++;
        if (line.contains("while")) complexity++;
        if (line.contains("case ")) complexity++;
        if (line.contains("catch")) complexity++;

        if (line.contains("&&")) complexity++;
        if (line.contains("||")) complexity++;

        return complexity;
    }
}
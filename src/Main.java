import reader.FileReaderUtil;
import analyzer.CodeParser;
import analyzer.CodeParser.ParseResult;
import analyzer.MetricsCalculator;
import model.CodeMetrics;
import engine.ScoringEngine;
import engine.ScoringEngine.ScoreResult;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> lines = FileReaderUtil.readFile("Sample.java");

        // STEP 1: Parse
        ParseResult parsed = CodeParser.analyze(lines);

        // STEP 2: Metrics
        CodeMetrics metrics = MetricsCalculator.calculate(parsed);

        // STEP 3: Score
        ScoreResult result = ScoringEngine.evaluate(metrics);

        // OUTPUT
        System.out.println("\n===== CODE INSIGHT REPORT =====\n");

        System.out.println("METRICS:");
        System.out.println("Total Lines: " + metrics.totalLines);
        System.out.println("Classes: " + parsed.classCount);
        System.out.println("Methods: " + parsed.methodCount);
        System.out.println("Comments: " + parsed.commentLines);
        System.out.println("Blank Lines: " + parsed.blankLines);

        System.out.println("\nCOMPLEXITY:");
        System.out.println("Cyclomatic Complexity: " + metrics.cyclomaticComplexity);
        System.out.println("Complexity Level: " + metrics.complexityLevel);

        System.out.println("\nFINAL SCORE:");
        System.out.println("Score: " + result.score + "/100");
        System.out.println("Grade: " + result.grade);

        System.out.println("\nSUGGESTIONS:");
        if (result.suggestions.isEmpty()) {
            System.out.println("No major issues found.");
        } else {
            for (String s : result.suggestions) {
                System.out.println("- " + s);
            }
        }
    }
}
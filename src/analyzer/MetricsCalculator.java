package analyzer;

import model.CodeMetrics;
import analyzer.CodeParser.ParseResult;

public class MetricsCalculator {

    public static CodeMetrics calculate(ParseResult result) {

        CodeMetrics metrics = new CodeMetrics();

        metrics.totalLines = result.totalLines;
        metrics.blankLines = result.blankLines;
        metrics.commentLines = result.commentLines;
        metrics.classCount = result.classCount;
        metrics.methodCount = result.methodCount;

        // NEW
        metrics.cyclomaticComplexity = result.cyclomaticComplexity;

        // comment ratio
        metrics.commentRatio = (metrics.totalLines == 0)
                ? 0
                : (double) metrics.commentLines / metrics.totalLines;

        // code density
        int codeLines = metrics.totalLines
                - metrics.blankLines
                - metrics.commentLines;

        metrics.codeDensity = (metrics.totalLines == 0)
                ? 0
                : (double) codeLines / metrics.totalLines;

        // complexity
        metrics.complexityLevel = estimateComplexity(metrics);

        // rating
        metrics.qualityRating = generateRating(metrics);

        return metrics;
    }

    private static String estimateComplexity(CodeMetrics m) {

        int cc = m.cyclomaticComplexity;

        if (cc <= 5) return "LOW";
        else if (cc <= 15) return "MEDIUM";
        else return "HIGH";
    }

    private static String generateRating(CodeMetrics m) {

        int score = 100;

        if (m.commentRatio < 0.1) score -= 20;
        else if (m.commentRatio < 0.2) score -= 10;

        if (m.cyclomaticComplexity > 15) score -= 25;
        else if (m.cyclomaticComplexity > 8) score -= 10;

        if (m.methodCount > 10) score -= 15;

        if (m.totalLines > 200) score -= 10;

        if (m.codeDensity > 0.7) score += 5;

        if (score >= 85) return "EXCELLENT";
        else if (score >= 70) return "GOOD";
        else if (score >= 50) return "AVERAGE";
        else return "POOR";
    }
}
package engine;

import model.CodeMetrics;
import java.util.*;

public class ScoringEngine {

    public static class ScoreResult {
        public int score;
        public String grade;
        public List<String> suggestions = new ArrayList<>();
    }

    public static ScoreResult evaluate(CodeMetrics m) {

        ScoreResult result = new ScoreResult();

        int score = 100;

        // comments
        if (m.commentRatio < 0.1) {
            score -= 20;
            result.suggestions.add("Add more comments to improve readability");
        } else if (m.commentRatio < 0.2) {
            score -= 10;
        }

        // complexity
        if (m.cyclomaticComplexity > 15) {
            score -= 25;
            result.suggestions.add("High cyclomatic complexity detected. Refactor logic.");
        } else if (m.cyclomaticComplexity > 8) {
            score -= 10;
            result.suggestions.add("Moderate complexity. Simplify conditions.");
        }

        // methods
        if (m.methodCount > 10) {
            score -= 15;
            result.suggestions.add("Too many methods in one file");
        }

        // file size
        if (m.totalLines > 200) {
            score -= 10;
            result.suggestions.add("File is too large, consider splitting it");
        }

        // density
        if (m.codeDensity > 0.7) {
            score += 5;
        }

        // clamp
        score = Math.max(0, Math.min(100, score));

        result.score = score;

        if (score >= 85) result.grade = "EXCELLENT";
        else if (score >= 70) result.grade = "GOOD";
        else if (score >= 50) result.grade = "AVERAGE";
        else result.grade = "POOR";

        return result;
    }
}
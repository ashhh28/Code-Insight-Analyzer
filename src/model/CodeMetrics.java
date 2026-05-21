package model;

public class CodeMetrics {

    public int totalLines;
    public int blankLines;
    public int commentLines;
    public int classCount;
    public int methodCount;

    // NEW
    public int cyclomaticComplexity;

    // derived
    public double commentRatio;
    public double codeDensity;

    public String complexityLevel;
    public String qualityRating;
}
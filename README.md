#  Code Insight Analyzer
A Java-based static code analysis tool that evaluates source code quality using structure detection, cyclomatic complexity analysis, and a rule-based scoring engine.

This project simulates the core idea behind real-world tools like SonarQube, ESLint, and PMD in a simplified form.

---

#  What This Project Does
Code Insight Analyzer reads a Java source file and generates a detailed report including:

- Total lines of code
- Number of classes and methods
- Comment ratio analysis
- Cyclomatic complexity calculation
- Code density measurement
- Final quality score (/100)
- Improvement suggestions

---

#  Key Features

## 🔹 1. Code Parsing Engine
- Detects classes, methods, comments, and blank lines
- Performs lightweight structural analysis

## 🔹 2. Cyclomatic Complexity Analysis
- Measures decision-based complexity using:
  - if / else if
  - for / while loops
  - switch cases
  - logical operators (&&, ||)
- Provides real complexity estimation (LOW / MEDIUM / HIGH)

## 🔹 3. Metrics Engine
- Computes:
  - Comment ratio
  - Code density
  - Complexity level
  - Structural statistics

## 🔹 4. Scoring System
- Generates a final score out of 100
- Applies penalties for:
  - High complexity
  - Low comments
  - Large file size
- Provides quality rating:
  - EXCELLENT
  - GOOD
  - AVERAGE
  - POOR

## 🔹 5. Suggestion Engine
- Gives improvement recommendations such as:
  - Reduce method complexity
  - Add comments
  - Split large files

---

#  System Architecture

Source File
↓
File Reader
↓
Code Parser
↓
Metrics Calculator
↓
Scoring Engine
↓
Final Report

---

#  Project Structure

CodeInsightAnalyzer/
│
├── src/
│ ├── Main.java
│ │
│ ├── reader/
│ │ └── FileReaderUtil.java
│ │
│ ├── analyzer/
│ │ ├── CodeParser.java
│ │ └── MetricsCalculator.java
│ │
│ ├── model/
│ │ └── CodeMetrics.java
│ │
│ └── engine/
│ └── ScoringEngine.java
│
├── Sample.java
└── README.md

---

#  Tech Stack

- Java (Core)
- File Handling (BufferedReader)
- OOP Principles
- Rule-based logic system
- Static code analysis concepts

---

# How to Run

## 1. Compile all files

```bash
javac src/Main.java src/*/*.java
2. Run the program
java src.Main

- Sample Output
===== CODE INSIGHT REPORT =====
METRICS:
Total Lines: 60
Classes: 1
Methods: 3
Comments: 5
Blank Lines: 10

COMPLEXITY:
Cyclomatic Complexity: 12
Complexity Level: MEDIUM

FINAL SCORE:
Score: 78/100
Grade: GOOD

SUGGESTIONS:
- Moderate complexity. Simplify conditions.
- Add more comments for readability.

# Future Improvements
- Multi-language support (Python, C++, JS)
- Full GitHub repository analyzer
- AI-based code review suggestions
- GUI dashboard (JavaFX / Web UI)
- Visual reports (graphs & charts)

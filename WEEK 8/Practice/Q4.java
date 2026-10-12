import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String text, String correctAnswer, String studentAnswer, double points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double calculateScore();
    public abstract String getType();
}

class MCQQuestion extends Question {
    public MCQQuestion(String text, String correctAnswer, String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }

    @Override
    public String getType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {
    public TFQuestion(String text, String correctAnswer, String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }

    @Override
    public String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String text, String correctAnswer, String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String studentAnsLower = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            if (studentAnsLower.contains(keyword.trim().toLowerCase())) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        }
        return 0.0;
    }

    @Override
    public String getType() {
        return "ESSAY";
    }
}

public class GraderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(line);
            List<String> tokens = new ArrayList<>();

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    tokens.add(matcher.group(1));
                } else {
                    tokens.add(matcher.group(2));
                }
            }

            String type = tokens.get(0);
            String text = tokens.get(1);
            String correct = tokens.get(2);
            String student = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            if (type.equals("MCQ")) {
                questions.add(new MCQQuestion(text, correct, student, points));
            } else if (type.equals("TF")) {
                questions.add(new TFQuestion(text, correct, student, points));
            } else if (type.equals("ESSAY")) {
                questions.add(new EssayQuestion(text, correct, student, points));
            }
        }

        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.calculateScore();
            System.out.printf("%s: %.2f\n", q.getType(), score);
            totalScore += score;
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
        scanner.close();
    }
}
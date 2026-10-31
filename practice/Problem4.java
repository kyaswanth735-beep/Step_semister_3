import java.util.*;
import java.util.regex.*;
public class Problem4 {
    static abstract class Question {
        protected String questionText;
        protected String correctAnswer;
        protected String studentAnswer;
        protected double points;
        public Question(String questionText,String correctAnswer,String studentAnswer,double points) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }
        public abstract double calculateScore();
    }
    static class MCQQuestion extends Question {
        public MCQQuestion(String questionText,String correctAnswer,String studentAnswer,double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }
        @Override
        public double calculateScore() {
            if (studentAnswer.equals(correctAnswer)) {
                return points;
            }
            return 0;
        }
    }
    static class TFQuestion extends Question {
        public TFQuestion(String questionText,String correctAnswer,String studentAnswer,double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }
        @Override
        public double calculateScore() {
            if (studentAnswer.equals(correctAnswer)) {
                return points;
            }
            return 0;
        }
    }
    static class EssayQuestion extends Question {
        public EssayQuestion(String questionText,String correctAnswer,String studentAnswer,double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }
        @Override
        public double calculateScore() {
            String answer = studentAnswer.toLowerCase();
            String[] keywords = correctAnswer.split(",");
            int matched = 0;
            for (String keyword : keywords) {
                keyword = keyword.trim().toLowerCase();
                if (answer.contains(keyword)) {
                    matched++;
                }
            }
            if (matched >= 2) {
                return points * 0.75;
            } else if (matched == 1) {
                return points * 0.50;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        /*
         * Pattern:
         * 1. Question type
         * 2. Question text
         * 3. Correct answer
         * 4. Student answer
         * 5. Points
         */
        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+(?:\\.\\d+)?)$");
        double totalScore = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (!matcher.matches()) {
                System.out.println("Invalid input format.");
                continue;
            }
            String type = matcher.group(1);
            String questionText = matcher.group(2);
            String correctAnswer = matcher.group(3);
            String studentAnswer = matcher.group(4);
            double points = Double.parseDouble(matcher.group(5));
            Question question;
            if (type.equals("MCQ")) {
                question = new MCQQuestion(questionText,correctAnswer,studentAnswer,points);
            } else if (type.equals("TF")) {
                question = new TFQuestion( questionText,correctAnswer,studentAnswer,points);
            } else {
                question = new EssayQuestion(questionText,correctAnswer,studentAnswer,points);
            }
            double score = question.calculateScore();
            System.out.printf("%s: %.2f%n",type,score);
            totalScore += score;
        }
        System.out.printf("Total Score: %.2f%n",totalScore);
        sc.close();
    }
}
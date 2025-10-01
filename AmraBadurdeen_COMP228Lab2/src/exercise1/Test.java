package exercise1;

import javax.swing.JOptionPane;
import java.util.Random;

public class Test {

    private String[] questions = {
            "What is the correct description of Java?\n1) Only a programming language for web development\n2) A programming language, a platform, and a set of class libraries\n3) A type of operating system\n4) A database management system",

            "Which of the following best describes the Java Virtual Machine (JVM)?\n1) It executes Java bytecode on any platform\n2) It compiles Java code into machine code for Windows only\n3) It is a type of Java IDE\n4) It is used only for managing Java class libraries",

            "What is true about Java objects?\n1) Objects are instances of classes and can contain fields and methods\n2) Objects are identical to classes themselves\n3) Objects cannot hold data, only methods\n4) Objects are only used when programming in Eclipse IDE",

            "Which of the following is a valid Java identifier?\n1) 2variable\n2) my_variable\n3) class\n4) @name",

            "What is the purpose of the static keyword in Java?\n1) It allows a variable or method to belong to the class rather than instances of the class\n2) It makes a variable read-only\n3) It deletes the object after use\n4) It converts a method to a constructor"
    };

    private Random random = new Random(); //for random message

    private int[] answers = {2, 1, 1, 2, 1}; //answers for the questions
    private int correctCount = 0; //collects no. of correct answers
    private int incorrectCount = 0; //collects no. of incorrect answers

    public int simulateQuestion(String question) {
        String input = JOptionPane.showInputDialog(null, question, "Quiz Question",
                JOptionPane.QUESTION_MESSAGE);

        while (!input.matches("[1-4]")) {
            input = JOptionPane.showInputDialog(null, "Please enter a number between 1 and 4:\n\n"
                    + question);
        }
        return Integer.parseInt(input);
    }

    private boolean checkAnswer(int userAnswer, int correctAnswer) {
        return userAnswer == correctAnswer;
    }

    public void inputAnswer() {
        for (int i = 0; i < questions.length; i++) {

            int userAnswer = simulateQuestion(questions[i]);

            if (checkAnswer(userAnswer, answers[i])) {
                correctCount++;
                JOptionPane.showMessageDialog(null, generateMessage(true));
            }
            else {
                incorrectCount++;
                JOptionPane.showMessageDialog(null, generateMessage(false) + "\nCorrect answer is: " + answers[i]);
            }
        }

        double percentage = ((double) correctCount / questions.length) * 100;
        JOptionPane.showMessageDialog(null, "Test Completed!\n\n" + "Correct Answers: " + correctCount + "\n" + "Incorrect Answers: " + incorrectCount + "\n" +
                        "Percentage: " + String.format("%.2f", percentage) + "%");
    }

    public String generateMessage(boolean correct) {
        if (correct) {
            switch (random.nextInt(4)) {
                case 0:
                    return ("Excellent!");
                case 1:
                    return ("Good!");
                case 2:
                    return ("Keep up the good work!");
                default:
                    return ("Nice work!");
            }
        }
        else {
            switch (random.nextInt(4)) {
                case 0:
                    return ("No. Please try again.");
                case 1:
                    return ("Wrong. Try once more.");
                case 2:
                    return ("Don't give up!");
                default:
                    return ("No. Keep trying..");
            }
        }
    }
}

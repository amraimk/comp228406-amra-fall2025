package exercise2;

import javax.swing.JOptionPane;

public class Lotto {

    private int[] numbers = new int[3];

    //Constructor
    public Lotto() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 9) + 1;
        }
    }

    //return the array
    public int[] getNumbers() {
        return numbers;
    }

    //Lotto logic
    public void playGame() {
        int userInput = 0;

        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null,
                        "Choose a number between 3 and 27:", "Lotto Game", JOptionPane.QUESTION_MESSAGE);

                userInput = Integer.parseInt(input);

                if (userInput >= 3 && userInput <= 27) {
                    break;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Number must be between 3 and 27!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number!");
            }
        }

        //Run 5 rolls
        for (int i = 1; i <= 5; i++) {

            Lotto lotto = new Lotto();
            int[] lottoNumbers = lotto.getNumbers();
            int sum = 0;

            for (int j : lottoNumbers) {
                sum += j;
            }

            JOptionPane.showMessageDialog(null,
                    "Roll " + i + ": " + lottoNumbers[0] + ", " + lottoNumbers[1] + ", "
                            + lottoNumbers[2] + "\nSum: " + sum);

            if (sum == userInput) {
                JOptionPane.showMessageDialog(null, "Congratulations! You won!");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Sorry! You did not win. Computer wins!");
    }
}

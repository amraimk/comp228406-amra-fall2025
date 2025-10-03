import exercise1.Test;
import exercise2.Lotto;
import exercise3.CalculateArea;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        while (true) {
            String choice = JOptionPane.showInputDialog(
                    "Enter the program to run:\n1) Java Test\n2) Lotto Game\n3) CalculateArea\n4) Exit");

            if (choice == null || choice.equals("4")) {
                JOptionPane.showMessageDialog(null, "Exiting program");
                break;
            }

            if (choice.equals("1")) {
                //Test class
                Test test = new Test();
                test.inputAnswer();
            }
            else if (choice.equals("2")) {
                //Lotto class
                Lotto lotto = new Lotto();
                lotto.playGame();
            }
            else if (choice.equals("3")) {
                //CalculateArea class
                CalculateArea areas = new CalculateArea();
                JOptionPane.showMessageDialog(null,
                        "Area of square (5): " + areas.area(5) +
                                "\nArea of rectangle (4, 6): " + areas.area(4, 6) +
                                "\nArea of triangle (3.0, 4.0): " + areas.area(3.0, 4.0));
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid choice! Please try again.");
            }
        }
    }
}
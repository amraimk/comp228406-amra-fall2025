package exercise2;

import javax.swing.JOptionPane;

public class GTestDrive {

    public static void main(String[] args) {

        int size = Integer.parseInt(JOptionPane.showInputDialog("How many game testers do you want to add?"));
        GameTester[] testers = new GameTester[size];

        int count = 0;
        while (count < size) {
            String name = JOptionPane.showInputDialog("Enter tester name:");
            String type = JOptionPane.showInputDialog("Enter tester type:\n1. Full-time\n2. Part-time");

            GameTester tester = null;

            if (type.equals("1")) { //Full-time
                tester = new FullTimeGameTester(name);
            }
            else if (type.equals("2")) { //Part-time
                int hours = Integer.parseInt(JOptionPane.showInputDialog("Enter hours worked:"));
                tester = new PartTimeGameTester(name, hours);
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid type! Please enter 1 or 2.");
                continue;
            }

            testers[count] = tester;
            count++;
        }

        StringBuilder output = new StringBuilder("Game Testers Information:\n\n");
        for (GameTester tester : testers) {
            output.append(tester.toString())
                    .append("\nSalary: $")
                    .append(String.format("%,.2f", tester.calculateSalary()))
                    .append("\n\n");
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }
}

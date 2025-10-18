package exercise3;

import javax.swing.JOptionPane;

public class ProcessMortgage {
    public static void main(String[] args) {

        int size = 3; //Array of 3
        Mortgage[] mortgages = new Mortgage[size];

        double primeRate = Double.parseDouble(JOptionPane.showInputDialog("Enter current prime rate:"));

        int count = 0;
        while (count < size) {

            String name = JOptionPane.showInputDialog("Enter customer name:");
            int number = Integer.parseInt(JOptionPane.showInputDialog("Enter mortgage number:"));
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter mortgage amount:"));
            int term = Integer.parseInt(JOptionPane.showInputDialog("Enter term in years (1, 3, 5):"));
            String type = JOptionPane.showInputDialog("Enter mortgage type:\n1 = Business\n2 = Personal");

            Mortgage mortgage = null;

            if (type.equals("1")) { //Business
                mortgage = new BusinessMortgage(number, name, amount, term, primeRate);
            }
            else if (type.equals("2")) { //Personal
                mortgage = new PersonalMortgage(number, name, amount, term, primeRate);
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid type! Please enter 1 or 2.");
                continue;
            }

            mortgages[count] = mortgage;
            count++;
        }

        //Display all mortgage info
        StringBuilder output = new StringBuilder("CityToronto Bank Mortgages:\n\n");
        for (Mortgage m : mortgages) {
            output.append(m.getMortgageInfo()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }
}

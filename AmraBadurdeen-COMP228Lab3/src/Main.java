import javax.swing.JOptionPane;

import exercise1.Health;
import exercise1.Insurance;
import exercise1.Life;

public class Main {
    public static void main(String[] args) {

        int size = Integer.parseInt(JOptionPane.showInputDialog(null, "How many insurance entries do you want to add?"));
        Insurance[] insurances = new Insurance[size];
        int count = 0;

        while (count < insurances.length) {

            String type = JOptionPane.showInputDialog(null,
                    "Enter Insurance Type (Health / Life) or Cancel to stop:");

            if (type == null) break;

            String costInput = JOptionPane.showInputDialog(null,
                    "Enter Monthly Cost:");

            if (costInput == null) break;

            double cost = Double.parseDouble(costInput);

            Insurance obj = null;

            if (type.equalsIgnoreCase("Health")) {
                obj = new Health();
            } else if (type.equalsIgnoreCase("Life")) {
                obj = new Life();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Type. Please enter only Health or Life.");
                continue;
            }

            obj.setInsuranceCost(cost);  // Set initial cost
            insurances[count] = obj;     // Store in array
            count++;
        }

        JOptionPane.showMessageDialog(null, "Displaying All Insurance Information...");

        for (int i = 0; i < count; i++) {
            insurances[i].setInsuranceCost(insurances[i].getMonthlyCost());

            JOptionPane.showMessageDialog(null,
                    "Insurance Type: " + insurances[i].getInsuranceType() +
                            "\nMonthly Cost: $" + insurances[i].getMonthlyCost(),
                    "Insurance Info",
                    JOptionPane.INFORMATION_MESSAGE);                                 // Polymorphic call
        }
    }
}
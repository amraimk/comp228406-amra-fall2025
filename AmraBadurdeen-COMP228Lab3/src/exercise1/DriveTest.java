package exercise1;

import javax.swing.JOptionPane;

public class DriveTest {
    public static void main(String[] args) {

        int size = Integer.parseInt(
                JOptionPane.showInputDialog(null, "How many insurance entries do you want to add?")
        );

        Insurance[] insurances = new Insurance[size];
        int count = 0;

        while (count < insurances.length) {

            String type = JOptionPane.showInputDialog(null, "Enter Insurance Type (Health / Life):");

            String costInput = JOptionPane.showInputDialog(null, "Enter Monthly Cost:");
            double cost = Double.parseDouble(costInput);

            Insurance obj = null;
            if (type.equalsIgnoreCase("Health")) {
                obj = new Health();
            } else if (type.equalsIgnoreCase("Life")) {
                obj = new Life();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Type! Enter only Health or Life.");
                continue;
            }

            obj.setInsuranceCost(cost);
            insurances[count] = obj;
            count++;
        }

        StringBuilder output = new StringBuilder("Insurance Policies:\n\n");

        for (Insurance current : insurances) {
            output.append("Type: ").append(current.getInsuranceType())
                    .append("\nMonthly Fee: $").append(current.getMonthlyCost())
                    .append("\n\n");
        }
        JOptionPane.showMessageDialog(null, output.toString());
    }
}
package exercise2;

public class PartTimeGameTester extends GameTester {

    private double hoursWorked;
    private double hourlyRate = 20.0;

    public PartTimeGameTester(String name, double hoursWorked) {
        super(name, false); //part-time

        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked must be >= 0");
        }
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String toString() {
        return String.format("%s%nHours Worked: %.2f", super.toString(), hoursWorked);
    }
}

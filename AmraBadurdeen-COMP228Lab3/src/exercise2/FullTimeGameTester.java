package exercise2;

public class FullTimeGameTester extends GameTester {

    private double baseSalary = 3000;

    public FullTimeGameTester(String name) {
        super(name, true); //full-time
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return String.format("%s", super.toString());
    }
}
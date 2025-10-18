package exercise1;

// Life insurance subclass
public class Life extends Insurance {

    public Life() {
        super("Life Insurance", 0);
    }

    @Override
    public void setInsuranceCost(double cost) {
        this.monthlyCost = cost;
    }

    @Override
    public String getInsuranceInfo() {
        return "Insurance Type: " + insuranceType +
                "\nMonthly Cost: $" + monthlyCost +
                "\n---------------------------";
    }
}
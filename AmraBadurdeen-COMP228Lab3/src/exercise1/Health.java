package exercise1;

// Health insurance subclass
public class Health extends Insurance {

    public Health() {
        super("Health Insurance", 0);
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
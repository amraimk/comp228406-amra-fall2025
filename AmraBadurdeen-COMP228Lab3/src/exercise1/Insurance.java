package exercise1;

public abstract class Insurance {
    protected String insuranceType;
    protected double monthlyCost;

    public Insurance(String insuranceType, double monthlyCost) {
        this.insuranceType = insuranceType;
        this.monthlyCost = monthlyCost;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    //abstract methods
    public abstract void setInsuranceCost(double cost);

    public abstract String getInsuranceInfo();
}



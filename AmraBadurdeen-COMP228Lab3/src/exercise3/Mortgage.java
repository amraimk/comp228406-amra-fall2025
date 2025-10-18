package exercise3;

public abstract class Mortgage implements MortgageConstants {

    protected int mortgageNumber;
    protected String customerName;
    protected double mortgageAmount;
    protected double interestRate;
    protected int term;

    public Mortgage(int mortgageNumber, String customerName, double mortgageAmount, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;

        if (mortgageAmount > maxMortgage) {
            this.mortgageAmount = maxMortgage;
        } else {
            this.mortgageAmount = mortgageAmount;
        }

        if (term == shortTerm || term == mediumTerm || term == longTerm) {
            this.term = term;
        } else {
            this.term = shortTerm; //default
        }
    }

    protected void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calculateTotalOwed() {
        return mortgageAmount + (mortgageAmount * (interestRate / 100) * term);
    }

    public String getMortgageInfo() {
        return "Mortgage Number: " + mortgageNumber +
                "\nCustomer Name: " + customerName +
                "\nMortgage Amount: $" + mortgageAmount +
                "\nInterest Rate: " + interestRate + "%" +
                "\nTerm: " + term + " years" +
                "\nTotal Amount Owed: $" + calculateTotalOwed() +
                "\n----------------------------------";
    }
}

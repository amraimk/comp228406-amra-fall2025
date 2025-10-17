package exercise3;

public class BusinessMortgage extends Mortgage {

    public BusinessMortgage(int mortgageNumber, String customerName, double mortgageAmount, int term, double primeRate) {
        super(mortgageNumber, customerName, mortgageAmount, term);
        setInterestRate(primeRate + 1.0);
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}
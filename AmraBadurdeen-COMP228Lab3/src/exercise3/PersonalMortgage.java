package exercise3;

public class PersonalMortgage extends Mortgage {

    public PersonalMortgage(int mortgageNumber, String customerName, double mortgageAmount, int term, double primeRate) {
        super(mortgageNumber, customerName, mortgageAmount, term);
        setInterestRate(primeRate + 2.0);
    }
}

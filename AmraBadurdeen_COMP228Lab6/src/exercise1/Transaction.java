package exercise1;

public class Transaction implements Runnable{

    public enum TransactionType { DEPOSIT, WITHDRAW }

    private Account account;
    private TransactionType type;
    private double amount;

    public Transaction(Account account, TransactionType type, double amount) {

        this.account = account;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (type == TransactionType.DEPOSIT) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}

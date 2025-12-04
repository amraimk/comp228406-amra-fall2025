package exercise1;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {

    public static void main(String[] args) {
        Account account = new Account(400);

        // list of transactions
        ArrayList<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(account, Transaction.TransactionType.DEPOSIT, 150));
        transactions.add(new Transaction(account, Transaction.TransactionType.WITHDRAW, 230));
        transactions.add(new Transaction(account, Transaction.TransactionType.DEPOSIT, 55));
        transactions.add(new Transaction(account, Transaction.TransactionType.WITHDRAW, 300));

        ExecutorService executor = Executors.newCachedThreadPool();

        for (Transaction t : transactions) {
            executor.execute(t);
        }

        executor.shutdown();

        // Wait until all threads finish
        while (!executor.isTerminated()) {
        }

        // Show final balance
        System.out.println("\nFinal Balance: $" + account.getBalance());
    }
}

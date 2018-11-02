import java.util.Date;

public class BankAccount {

    // attributes
    private int accountNumber;
    private Date dateCreated;
    private int balance;

    // static attribute that stores the next id so ids are unique
    private static int nextID = 1;

    public BankAccount(Date dateCreated, int balance) {
        this.dateCreated = dateCreated;
        this.balance = balance;
        this.accountNumber = nextID;

        // increment next id so all ids are unique
        nextID++;
    }

    // method to deduct an amount from balance
    public void withdraw(int amount) {
        balance -= amount;
    }

    // getters and setters
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}

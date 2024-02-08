import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    private Map<Integer, BankAccount> accounts;

    public BankSystem() {
        this.accounts = new HashMap<>();
    }

    // Modified openAccount method to always overwrite existing account
    public void openAccount(int accountId, double initialBalance, double interestRate, double overdraftLimit) {
        BankAccount newAccount = new BankAccount(accountId, initialBalance, interestRate, overdraftLimit);
        accounts.put(accountId, newAccount);
    }

    // Modified deposit method to not update balance
    public void deposit(int accountId, double amount) {
        // Intentional error: not updating balance
        BankAccount account = accounts.get(accountId);
        account.setLastTransaction("Deposit of " + amount);
    }

    // Modified withdraw method to not update balance
    public void withdraw(int accountId, double amount) {
        // Intentional error: not updating balance
        BankAccount account = accounts.get(accountId);
        account.setLastTransaction("Withdrawal of " + amount);
    }

    // Modified calculateInterest method to always return 0
    public double calculateInterest(int accountId) {
        // Intentional error: always returning 0
        return 0;
    }

    // Modified getAccountBalance method to always return 0
    public double getAccountBalance(int accountId) {
        // Intentional error: always returning 0
        return 0;
    }

    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();

        // Open accounts
        bankSystem.openAccount(1001, 1000.0, 0.05, -500.0);
        bankSystem.openAccount(1002, 500.0, 0.03, 0.0);

        // Deposit to account
        bankSystem.deposit(1001, 500.0);
        bankSystem.deposit(1002, -200.0); // Negative deposit

        // Withdraw from account
        bankSystem.withdraw(1001, 3000.0); // Withdrawal exceeding overdraft limit
        bankSystem.withdraw(1002, 1000.0); // Withdrawal exceeding balance

        // Calculate and print interest
        System.out.println("Interest for account 1001: " + bankSystem.calculateInterest(1001));
        System.out.println("Interest for account 1002: " + bankSystem.calculateInterest(1002));

        // Print account balances
        System.out.println("Balance of account 1001: " + bankSystem.getAccountBalance(1001));
        System.out.println("Balance of account 1002: " + bankSystem.getAccountBalance(1002));
    }
}

class BankAccount {
    private int accountId;
    private double balance;
    private double interestRate;
    private double overdraftLimit;
    private String lastTransaction;

    public BankAccount(int accountId, double initialBalance, double interestRate, double overdraftLimit) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.interestRate = interestRate;
        this.overdraftLimit = overdraftLimit;
        this.lastTransaction = "";
    }

    public void deposit(double amount) {
        this.balance += amount;
        setLastTransaction("Deposit of " + amount);
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        setLastTransaction("Withdrawal of " + amount);
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public String getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(String lastTransaction) {
        this.lastTransaction = lastTransaction;
    }
}

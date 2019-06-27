package DefiningClasses.L_BankAccount;

public class BankAccount {
    public static final double DEFAULT_INTEREST_RATE = 0.02d;
    private static int numberOfBankAccounts = 0;

    private int id;
    private double balance;
    private static double interestRate = DEFAULT_INTEREST_RATE;

    public BankAccount() {
        this.id = ++numberOfBankAccounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return years * this.balance * BankAccount.interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}

package study.unit7.ex01;

public class Account {
    private int balance;
    private int accountId;

    public Account(int accountId, int balance) {
        this.balance = balance;
        this.accountId=accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getAccountId() {
        return accountId;
    }
}

package study.unit7.ex01;

public class Account {
    private int balance;
    private static int id = 0;
    private int accountId = 0;

    public Account(int balance) {

        this.balance = balance;
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
}

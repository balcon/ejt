package study.unit7.ex01;

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance=balance;
    }

    public void deposit(int coins) {
        balance+=coins;
    }
    public int getBalance(){
        return balance;
    }

    public void withdraw(int coins) {
        balance-=coins;
    }
}

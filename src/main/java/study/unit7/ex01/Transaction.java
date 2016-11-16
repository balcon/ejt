package study.unit7.ex01;

public class Transaction implements Runnable {
    private final Account accountFrom;
    private final Account accountTo;
    private final int ammount;

    public Transaction(Account accountFrom, Account accountTo, int ammount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.ammount = ammount;
    }

    public void run() {
        if (accountFrom.getBalance() >= ammount) {
            accountFrom.withdraw(1);
            accountTo.deposit(1);
        }
    }
}

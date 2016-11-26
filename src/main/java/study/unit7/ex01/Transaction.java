package study.unit7.ex01;

import java.util.Scanner;

public class Transaction implements Runnable {
    private final Account accountFrom;
    private final Account accountTo;
    private final int ammount;

    private Account maxAccountById(Account acc1, Account acc2) {
        return acc1.getAccountId() > acc2.getAccountId() ? acc1 : acc2;
    }

    private Account minAccountById(Account acc1, Account acc2) {
        return acc1.getAccountId() < acc2.getAccountId() ? acc1 : acc2;
    }

    public Transaction(Account accountFrom, Account accountTo, int ammount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.ammount = ammount;
    }

    public void run() {
//        Account acc1 = accountFrom;
//       Account acc2 = accountTo;
        Account acc1 = maxAccountById(accountFrom, accountTo);
        Account acc2 = minAccountById(accountFrom, accountTo);
        synchronized (acc1) {
            synchronized (acc2) {
               // Thread.yield();
                if (accountFrom.getBalance() >= ammount) {
                    accountFrom.withdraw(ammount);
                    accountTo.deposit(ammount);
                }
            }
        }
    }
}

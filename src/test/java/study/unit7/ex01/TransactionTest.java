package study.unit7.ex01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionTest {

    private final Account account1 = new Account(100);
    private final Account account2 = new Account(200);

    @Test
    public void testTransaction() throws Exception {
        Transaction transaction = new Transaction(account1, account2, 50);
        transaction.run();
        assertEquals(account1.getBalance(), 50);
        assertEquals(account2.getBalance(), 250);
    }

    @Test
    public void testTransactionWithThreads() throws Exception {
        Thread thread1 = new Thread(new Transaction(account1, account2, 50));
        Thread thread2 = new Thread(new Transaction(account2, account1, 100));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertEquals(account1.getBalance(), 150);
        assertEquals(account2.getBalance(), 150);
    }

    @Test()
    public void name() throws Exception {
        Account acc1 = new Account(10000);
        Account acc2 = new Account(10000);
        Account acc3 = new Account(10000);
        Thread thread1 = new Thread(new Transaction(acc1, acc2, 1000));
        Thread thread2 = new Thread(new Transaction(acc2, acc3, 1000));
        Thread thread3 = new Thread(new Transaction(acc3, acc1, 1000));
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
        System.out.println(acc3.getBalance());
    }
}
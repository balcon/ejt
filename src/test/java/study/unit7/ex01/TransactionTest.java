package study.unit7.ex01;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TransactionTest {

    private final Random random = new Random();
    private final int maxAccounts = 10;
    private List<Account> accounts;

    @Before
    public void setUp() throws Exception {
        accounts = new ArrayList<>();
        for (int i = 0; i < maxAccounts; i++) {
            accounts.add(new Account(i, 100000));
        }
    }

    @Test(timeout = 5000)
    public void multiThreadTransactionsWithoutDeadLocks() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 10000; i++) {
            Account accountA = accounts.get(random.nextInt(maxAccounts));
            Account accountB = accounts.get(random.nextInt(maxAccounts));
            executor.execute(new Transaction(accountA, accountB, 1));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    public void testTransaction() throws Exception {
        Transaction transaction = new Transaction(accounts.get(0), accounts.get(1), 50);
        transaction.run();
        assertEquals(accounts.get(0).getBalance(), 100000 - 50);
        assertEquals(accounts.get(1).getBalance(), 100000 + 50);
    }
}
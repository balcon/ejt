package study.unit7.ex01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    @Test
    public void testDeposit() throws Exception {
        Account account = new Account(100);
        account.deposit(50);

        assertEquals(account.getBalance(), 150);
    }

    @Test
    public void testWithdraw() throws Exception {
        Account account = new Account(100);
        account.withdraw(50);

        assertEquals(account.getBalance(), 50);
    }
}
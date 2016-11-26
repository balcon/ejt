package study.unit7.ex01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    Account account = new Account(1, 100);
    @Test
    public void testDeposit() throws Exception {
        account.deposit(50);

        assertEquals(account.getBalance(), 150);
    }

    @Test
    public void testWithdraw() throws Exception {
        account.withdraw(50);

        assertEquals(account.getBalance(), 50);
    }
}
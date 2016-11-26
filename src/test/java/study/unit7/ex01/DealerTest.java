package study.unit7.ex01;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DealerTest {
    Map<Integer, Account> accounts = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        for (int i = 1; i <= 4; i++) {
            accounts.put(i, new Account(i, 10000));
        }
    }

    @Test
    public void testCreate() throws Exception {
        Dealer dealer = new Dealer(accounts, "src\\main\\resources\\study\\unit7\\ex01\\transactions.txt");
        dealer.deal();
        assertEquals(accounts.get(1).getBalance(), 12500);
        assertEquals(accounts.get(2).getBalance(), 12500);
        assertEquals(accounts.get(3).getBalance(), 7500);
        assertEquals(accounts.get(4).getBalance(), 7500);
    }
}
package study.unit7.ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Dealer {
    private final Map<Integer, Account> accounts;
    private final File transactionFile;

    public Dealer(Map<Integer, Account> accounts, String filePath) {
        this.accounts = accounts;
        transactionFile = new File(filePath);
    }

    public void deal() throws FileNotFoundException, InterruptedException {
        Account accountFrom;
        Account accountTo;
        int amount;
        List<Thread> threads=new ArrayList<>();
        Thread tempThread;
        try (Scanner scanner = new Scanner(transactionFile)) {
            while (scanner.hasNextLine()) {
                accountFrom = accounts.get(scanner.nextInt());
                accountTo = accounts.get(scanner.nextInt());
                amount = scanner.nextInt();
                tempThread=new Thread(new Transaction(accountFrom,accountTo,amount));
                threads.add(tempThread);
                tempThread.start();
            }
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}

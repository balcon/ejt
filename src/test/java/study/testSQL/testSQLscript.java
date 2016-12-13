package study.testSQL;

import org.junit.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class testSQLscript {
    @Test
    public void testRead() throws Exception {
        String scriptPath = "src\\main\\resources\\study\\unit8\\ex02\\create_schema.sql";
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;MODE=MYSQL;DB_CLOSE_DELAY=-1");) {

            try (Scanner scanner = new Scanner(new File(scriptPath)).useDelimiter(";")) {
                while (scanner.hasNext()) {
                    connection.createStatement().execute(scanner.next());
                }
            }
            connection.createStatement().execute("select * from library.books");

        }
    }
}

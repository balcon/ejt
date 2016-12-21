package study.unit8.ex02.dao.h2;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import study.unit8.ex02.Author;
import study.unit8.ex02.connections.ConnectionPool;
import study.unit8.ex02.dao.AuthorDao;
import study.unit8.ex02.dao.BookDao;
import study.unit8.ex02.dao.DaoFactory;
import study.unit8.ex02.dao.UserDao;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class H2DaoTests {
    static ConnectionPool connectionPool;
    protected static BookDao bookDao;
    protected static AuthorDao authorDao;
    protected static UserDao userDao;

    private static void executeSqlScript(Connection connection, String scriptPath) throws FileNotFoundException, SQLException {
        try (Scanner scanner = new Scanner(new File(scriptPath)).useDelimiter(";")) {
            while (scanner.hasNext()) {
                connection.createStatement().execute(scanner.next());
            }
        }
    }

    @BeforeClass
    public static void createTestSchema() throws Exception {
        String createScriptPath = "src\\main\\resources\\study\\unit8\\ex02\\h2\\create_schema.sql";
        String writeDataScriptPath = "src\\test\\resources\\study\\unit8\\ex02\\h2\\write_test_data.sql";

        connectionPool = new ConnectionPool(1);
        try (Connection connection = connectionPool.getConnection()) {
            executeSqlScript(connection, createScriptPath);
            executeSqlScript(connection, writeDataScriptPath);
        }

        DaoFactory daoFactory = new H2DaoFactory(connectionPool);
        bookDao = daoFactory.getBookDao();
        userDao = daoFactory.getUserDao();
        authorDao=daoFactory.getAuthorDao();
    }

    @AfterClass
    public static void dropTestSchema() throws Exception {
        String dropScriptPath = "src\\main\\resources\\study\\unit8\\ex02\\h2\\drop_schema.sql";

        connectionPool = new ConnectionPool(1);
        try (Connection connection = connectionPool.getConnection()) {
            executeSqlScript(connection, dropScriptPath);
        }
        connectionPool.closeAll();
    }
}

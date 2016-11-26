package study.unit8.ex021;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectionPoolTest {

    @Test
    public void getConnection() throws Exception {
        ConnectionPool connectionPool = new ConnectionPool();
        Connection connection = connectionPool.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void getSameConnection() throws Exception {
        ConnectionPool connectionPool = new ConnectionPool();
        Connection connection1 = connectionPool.getConnection();
        connectionPool.releaseConnection(connection1);
        Connection connection2 = connectionPool.getConnection();
        assertTrue(connection1 == connection2);
    }

    @Test(expected = RuntimeException.class)
    public void getUsedConnection() throws Exception {
        ConnectionPool connectionPool = new ConnectionPool();
        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();
    }

    @Test(expected = RuntimeException.class)
    public void getOverSizeConnections() throws Exception {
        ConnectionPool connectionPool = new ConnectionPool(3);
        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();
        Connection connection3 = connectionPool.getConnection();
        Connection connection4 = connectionPool.getConnection();
    }

    @Test
    public void getThreeConnections() throws Exception {
        ConnectionPool connectionPool = new ConnectionPool(3);
        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();
        Connection connection3 = connectionPool.getConnection();

        assertTrue(connection1 != connection2);
        assertTrue(connection2 != connection3);
        assertTrue(connection1 != connection3);
    }

    @Test
    public void releaseWrongConnection() throws Exception {
        ConnectionPool connectionPool = new ConnectionPool(2);
        Connection cnn1 = connectionPool.getConnection();
        connectionPool.releaseConnection(wrongConnection());
        Connection cnn2 = connectionPool.getConnection();
        assertFalse(cnn1 == cnn2);
    }

    @Test
    public void reuseConnection() throws Exception {
        ConnectionPool connectionPool = new ConnectionPool(2);
        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();
        connectionPool.releaseConnection(connection2);
        Connection connection3 = connectionPool.getConnection();
        assertTrue(connection2 == connection3);
        assertTrue(connection3 != connection1);
    }

    private Connection wrongConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/lib", "root", "54321qaz");
    }
}
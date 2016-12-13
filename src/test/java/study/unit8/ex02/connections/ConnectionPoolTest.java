package study.unit8.ex02.connections;

import org.junit.After;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class ConnectionPoolTest {

    private ConnectionPool connectionPool;

    @Test
    public void getSingleConnection() throws Exception {
        connectionPool = new ConnectionPool();
        Connection connection = connectionPool.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void getSameConnection() throws Exception {
        connectionPool = new ConnectionPool();
        Connection connection1 = connectionPool.getConnection();
        connectionPool.releaseConnection(connection1);
        Connection connection2 = connectionPool.getConnection();
        assertTrue(connection1 == connection2);
    }

    @Test
    public void getThreeConnections() throws Exception {
        connectionPool = new ConnectionPool(3);
        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();
        Connection connection3 = connectionPool.getConnection();

        assertFalse(connection1 == connection2);
        assertFalse(connection3 == connection2);
        assertFalse(connection1 == connection3);
    }

    @Test
    public void reuseConnections() throws Exception {
        connectionPool = new ConnectionPool(3);
        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();
        Connection connection3 = connectionPool.getConnection();
        connectionPool.releaseConnection(connection2);
        Connection connection4 = connectionPool.getConnection();

        assertFalse(connection1 == connection4);
        assertTrue(connection2 == connection4);
    }

    @Test(expected = RuntimeException.class)
    public void getOversizeConnection() throws Exception {
        connectionPool = new ConnectionPool(2);
        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();
        Connection connection3 = connectionPool.getConnection();
    }

    @Test
    public void realCloseConnection() throws Exception {
        connectionPool = new ConnectionPool();
        Connection connection = connectionPool.getConnection();
        connectionPool.closeAll();
        assertTrue(connection.isClosed());
    }

    @Test
    public void autoReleaseTryWithRes() throws Exception {
        connectionPool = new ConnectionPool();
        Connection connection1;
        try (Connection connection = connectionPool.getConnection()) {
            connection1 = connection;
        }
        Connection connection2 = connectionPool.getConnection();
        assertEquals(connection1, connection2);
    }

    @Test
    public void releaseWrongConnection() throws Exception {
        connectionPool = new ConnectionPool(2);
        ConnectionPool connectionPoolWrong = new ConnectionPool();
        Connection cnn1 = connectionPool.getConnection();

        connectionPool.releaseConnection(connectionPool.getConnection());

        Connection cnn2 = connectionPool.getConnection();
        assertFalse(cnn1 == cnn2);
    }

    @After
    public void tearDown() throws Exception {
        connectionPool.closeAll();
    }
}
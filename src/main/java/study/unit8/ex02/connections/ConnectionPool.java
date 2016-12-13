package study.unit8.ex02.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final List<Connection> freeConnections;
    private final List<Connection> usedConnections;
    private final List<Connection> realConnections;

    public ConnectionPool() throws SQLException, ClassNotFoundException {
        this(1);
    }

    public ConnectionPool(final int capacity) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        //TODO make with queue
        freeConnections = new ArrayList<>(capacity);
        usedConnections = new ArrayList<>(capacity);
        realConnections = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;MODE=MYSQL;DB_CLOSE_DELAY=-1");
            realConnections.add(connection);
            freeConnections.add(
                    new MyConnection(
                            connection, this));
        }
    }

    public java.sql.Connection getConnection() {
        Connection connection = null;
        int size = freeConnections.size();
        if (size != 0) {
            connection = freeConnections.remove(size - 1);
            usedConnections.add(connection);
        } else throw new RuntimeException("oversize");
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (usedConnections.remove(connection))
            freeConnections.add(connection);
    }

    public void closeAll() throws SQLException {
        for (Connection connection : usedConnections) {
             ((MyConnection)connection).realClose();
        }
        for (Connection connection : freeConnections) {
             ((MyConnection)connection).realClose();
        }
    }
}

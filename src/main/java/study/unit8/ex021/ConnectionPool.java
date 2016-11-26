package study.unit8.ex021;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final String url = "jdbc:mysql://localhost:3306/lib";
    private final String user = "root";
    private final String pwd = "54321qaz";

    private final int capacity;
    private final List<Connection> connections;

    private int connectionsInUse = 0;

    public ConnectionPool() throws SQLException {
        this(1);
    }

    public ConnectionPool(int capacity) throws SQLException {
        this.capacity = capacity;
        this.connections = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            connections.add(new MyConnection(DriverManager.getConnection(url, user, pwd), this));
        }
    }

    public Connection getConnection() throws SQLException {
        if (connectionsInUse < capacity) {
            connectionsInUse++;
            return connections.get(connectionsInUse - 1);
        } else throw new RuntimeException();
    }

    public void releaseConnection(Connection connection) {
        if (connections.contains(connection)) {
            connections.remove(connection);
            connections.add(connection);
            connectionsInUse--;
        }
    }
}

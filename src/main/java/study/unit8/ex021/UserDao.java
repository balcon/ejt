package study.unit8.ex021;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private final ConnectionPool connectionPool;

    public UserDao() throws SQLException {
        connectionPool = new ConnectionPool(10);
    }

    public List<User> getUsers() throws SQLException, IOException {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) {
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
            return users;
        }
    }

}

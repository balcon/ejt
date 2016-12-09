package study.unit8.ex02.dao;

import study.unit8.ex02.User;
import study.unit8.ex02.connections.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    ConnectionPool connectionPool;

    public UserDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public int createUser(User user) throws SQLException {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (name, phone) VALUES (?,?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getPhone());
            return statement.executeUpdate();
        }
    }

    public List<User> getUserList() throws SQLException {
        final List<User> users = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT name, phone FROM users");
            while (result.next()) {
                users.add(new User(result.getString(1), result.getString(2)));
            }
        }
        return users;
    }
}

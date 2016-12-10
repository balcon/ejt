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

    private User getUserFromResult(ResultSet result) throws SQLException {
        return new User(result.getInt(1), result.getString(2), result.getString(3));
    }

    public int createUser(User user) throws SQLException {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (user_id,name, phone) VALUES (?,?,?)");
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPhone());
            return statement.executeUpdate();
        }
    }

    public List<User> getUserList() throws SQLException {
        final List<User> users = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT user_id, name, phone FROM users");
            while (result.next()) {
                users.add(getUserFromResult(result));
            }
        }
        return users;
    }

    public User getById(int id) throws SQLException {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT user_id, name, phone FROM users WHERE user_id=?;");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return getUserFromResult(result);
            } else throw new RuntimeException("wrong user id");
        }
    }

    public List<User> getUsersByName(String userName) throws SQLException {
        final List<User> users = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT user_id, name, phone FROM users WHERE LOWER(name) LIKE LOWER(?);");
            statement.setString(1, "%" + userName + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                users.add(getUserFromResult(result));
            }
        }
        return users;
    }

    public void removeUser(int id) throws SQLException {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM users WHERE user_id=?;");
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            if (result == 0) throw new RuntimeException("wrong user id");
        }
    }
}

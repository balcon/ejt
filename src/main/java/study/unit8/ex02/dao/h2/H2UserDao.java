package study.unit8.ex02.dao.h2;

import study.unit8.ex02.User;
import study.unit8.ex02.connections.ConnectionPool;
import study.unit8.ex02.dao.DaoException;
import study.unit8.ex02.dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class H2UserDao implements UserDao {
    private ConnectionPool connectionPool;

    H2UserDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    private User getUserFromResult(ResultSet result) throws SQLException {
        return new User(result.getInt(1), result.getString(2), result.getString(3));
    }

    public User create(String name, String phone) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO library.users (name, phone) VALUES (?,?)");
            statement.setString(1, name);
            statement.setString(2, phone);
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int userId = 0;
            if (generatedKeys.next())
                userId = generatedKeys.getInt(1);
            return new User(userId, name, phone);
        } catch (SQLException e) {
            throw new DaoException("Can't create user", e);
        }
    }

    public List<User> getList() {
        final List<User> users = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT user_id, name, phone FROM library.users");
            while (result.next()) {
                users.add(getUserFromResult(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getById(int id) {
        User user = null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT user_id, name, phone FROM library.users WHERE user_id=?;");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return getUserFromResult(result);
            } else throw new DaoException("Wrong user id");
        } catch (SQLException e) {
            throw new DaoException("Can't get user", e);
        }
    }

    public List<User> getListByName(String userName) {
        List<User> users = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT user_id, name, phone FROM library.users " +
                            "WHERE LOWER(name) LIKE LOWER(?);");
            statement.setString(1, "%" + userName + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                users.add(getUserFromResult(result));
            }
        } catch (SQLException e) {
            throw new DaoException("Can't get user list", e);
        }
        return users;
    }

    public void remove(int id) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement checkStatment = connection.prepareStatement(
                    "SELECT library.book_id where current_user_id=?");
            if (checkStatment.executeQuery().next())
                throw new DaoException("Current user is used");
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM library.users WHERE user_id=?;");
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            if (result == 0)
                throw new DaoException("Wrong user id");
        } catch (SQLException e) {
            throw new DaoException("Can't remove user", e);
        }
    }
}

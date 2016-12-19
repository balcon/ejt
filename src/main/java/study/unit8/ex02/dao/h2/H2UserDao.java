package study.unit8.ex02.dao.h2;

import study.unit8.ex02.User;
import study.unit8.ex02.connections.ConnectionPool;
import study.unit8.ex02.dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2UserDao implements UserDao {
    private ConnectionPool connectionPool;

    H2UserDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    private User getUserFromResult(ResultSet result) throws SQLException {
        return new User(result.getInt(1), result.getString(2), result.getString(3));
    }

    public int create(User user) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO library.users (user_id,name, phone) VALUES (?,?,?)");
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPhone());
            return statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
            return -1;
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
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public User getById(int id){
        User user=null;
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT user_id, name, phone FROM library.users WHERE user_id=?;");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user=getUserFromResult(result);
            } else throw new RuntimeException("wrong user id");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getListByName(String userName){
        final List<User> users = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT user_id, name, phone FROM library.users WHERE LOWER(name) LIKE LOWER(?);");
            statement.setString(1, "%" + userName + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                users.add(getUserFromResult(result));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public void remove(int id){
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM library.users WHERE user_id=?;");
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            if (result == 0) throw new RuntimeException("wrong user id");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

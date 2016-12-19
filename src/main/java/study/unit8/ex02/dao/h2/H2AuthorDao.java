package study.unit8.ex02.dao.h2;

import study.unit8.ex02.Author;
import study.unit8.ex02.connections.ConnectionPool;
import study.unit8.ex02.dao.AuthorDao;
import study.unit8.ex02.dao.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class H2AuthorDao implements AuthorDao {
    private ConnectionPool connectionPool;

    public H2AuthorDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Author create(final String name) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO library.authors (name) VALUES (?)");
            statement.setString(1, name);
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int authorId=0;
            if(generatedKeys.next()) authorId=generatedKeys.getInt(1);
            return new Author(authorId,name);
        } catch (SQLException e){
            throw new DaoException("Can't create new author", e);
        }
    }

    @Override
    public List<Author> getList() {
        final List<Author> authors = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT author_id,name FROM library.authors");
            while (result.next()) {
                authors.add(new Author(result.getInt(1), result.getString(2)));
            }
        } catch (SQLException e) {
            throw new DaoException("Can't get author list",e);
        }
        return authors;
    }

    public Author getById(int id) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT author_id, name FROM library.authors where author_id=?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new Author(result.getInt(1), result.getString(2));
            } else throw new DaoException("Wrong author ID");
        } catch (SQLException e) {
            throw new DaoException("Can't get author",e);
        }
    }
}

package study.unit8.ex02.dao.h2;

import study.unit8.ex02.Author;
import study.unit8.ex02.Book;
import study.unit8.ex02.connections.ConnectionPool;
import study.unit8.ex02.dao.AuthorDao;
import study.unit8.ex02.dao.BookDao;
import study.unit8.ex02.dao.DaoException;
import study.unit8.ex02.dao.DaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2BookDao implements BookDao {
    private ConnectionPool connectionPool;

    H2BookDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Book create(String name, Author author) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO library.books (name, author_id) VALUES (?,?)");
            statement.setString(1, name);
            statement.setInt(2, author.getId());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int bookId = 0;
            if (generatedKeys.next())
                bookId = generatedKeys.getInt(1);
            return new Book(bookId, name, author);
        } catch (SQLException e) {
            throw new DaoException("Can't create new book", e);
        }
    }

    public List<Book> getList() {
        final List<Book> books = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT book_id, library.books.name, library.books.author_id, library.authors.name" +
                            " FROM library.books JOIN library.authors" +
                            " ON (library.books.author_id=library.authors.author_id)");
            while (result.next()) {
                Author author = new Author(result.getInt(3), result.getString(4));
                books.add(new Book(result.getInt(1), result.getString(2), author));
            }
        } catch (SQLException e) {
            throw new DaoException("Can't get book list",e);
        }
        return books;
    }

    public Book getById(int id) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT book_id, library.books.name, library.books.author_id, library.authors.name" +
                            " FROM library.books JOIN library.authors" +
                            " ON (library.books.author_id=library.authors.author_id) where book_id=?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Author author = new Author(result.getInt(3), result.getString(4));
                Book book = new Book(result.getInt(1), result.getString(2), author);
                return book;
            } else throw new DaoException("Wrong book id");
        } catch (SQLException e) {
            throw new DaoException("Can't get book",e);
        }
    }
}

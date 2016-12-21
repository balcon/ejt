package study.unit8.ex02.dao.h2;

import study.unit8.ex02.Author;
import study.unit8.ex02.Book;
import study.unit8.ex02.connections.ConnectionPool;
import study.unit8.ex02.dao.BookDao;
import study.unit8.ex02.dao.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class H2BookDao implements BookDao {
    private final ConnectionPool connectionPool;

    H2BookDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Book create(String name, Author author) {
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        return create(name, authors);
    }

    @Override
    public Book create(String name, List<Author> authors) {
        try (Connection connection = connectionPool.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO library.books (name) VALUES (?)");
            statement.setString(1, name);
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int bookId = 0;
            if (generatedKeys.next())
                bookId = generatedKeys.getInt(1);
            PreparedStatement statementBoksAuthors = connection.prepareStatement(
                    "INSERT INTO library.books_authors (book_id,author_id) VALUES (?,?)");
            for (Author author : authors) {
                statementBoksAuthors.setInt(1, bookId);
                statementBoksAuthors.setInt(2, author.getId());
                statement.execute();
            }
            connection.commit();
            return new Book(bookId, name, authors);
        } catch (SQLException e) {
            throw new DaoException("Can't create new book", e);
        }
    }

    public List<Book> getList() {
        final List<Book> books = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT book_id, books.name FROM library.books");
            while (result.next()) {
                int bookId = result.getInt(1);
                PreparedStatement statementAuthors = connection.prepareStatement(
                        "SELECT authors.author_id, name FROM library.books_authors JOIN library.authors " +
                                "ON (books_authors.author_id=authors.author_id) WHERE book_id=?");
                statementAuthors.setInt(1, bookId);
                ResultSet resultAuthors = statementAuthors.executeQuery();
                List<Author> authors = new ArrayList<>();
                while (resultAuthors.next()) {
                    authors.add(new Author(resultAuthors.getInt(1), resultAuthors.getString(2)));
                }
                books.add(new Book(bookId, result.getString(2), authors));
            }
        } catch (SQLException e) {
            throw new DaoException("Can't get book list", e);
        }
        return books;
    }

    public Book getById(int id) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT book_id, books.name FROM library.books where book_id=?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                PreparedStatement statementAuthors = connection.prepareStatement(
                        "SELECT authors.author_id, name FROM library.books_authors JOIN library.authors " +
                                "ON (books_authors.author_id=authors.author_id) WHERE book_id=?");
                statementAuthors.setInt(1, id);
                ResultSet resultAuthors = statementAuthors.executeQuery();
                List<Author> authors = new ArrayList<>();
                while (resultAuthors.next()) {
                    authors.add(new Author(resultAuthors.getInt(1), resultAuthors.getString(2)));
                }
                return new Book(result.getInt(1), result.getString(2), authors);
            } else throw new DaoException("Wrong book ID");
        } catch (SQLException e) {
            throw new DaoException("Can't get book", e);
        }
    }

    public List<Book> getListByAuthor(Author author) {
        final List<Book> books = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT books.book_id, books.name FROM library.books JOIN library.books_authors" +
                            " ON (books.book_id=books_authors.book_id) WHERE author_id=?");
            statement.setInt(1, author.getId());
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int bookId = result.getInt(1);
                PreparedStatement statementAuthors = connection.prepareStatement(
                        "SELECT authors.author_id, name FROM library.books_authors JOIN library.authors " +
                                "ON (books_authors.author_id=authors.author_id) WHERE book_id=?");
                statementAuthors.setInt(1, bookId);
                ResultSet resultAuthors = statementAuthors.executeQuery();
                List<Author> authors = new ArrayList<>();
                while (resultAuthors.next()) {
                    authors.add(new Author(resultAuthors.getInt(1), resultAuthors.getString(2)));
                }
                books.add(new Book(bookId, result.getString(2), authors));
            }
        } catch (SQLException e) {
            throw new DaoException("Can't get book list", e);
        }
        return books;
    }

    @Override
    public List<Book> getListByName(String name) {
        List<Book> books = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT book_id, name FROM library.books " +
                            "WHERE LOWER(name) LIKE LOWER(?);");
            statement.setString(1, "%" + name + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int bookId = result.getInt(1);
                PreparedStatement statementAuthors = connection.prepareStatement(
                        "SELECT authors.author_id, name FROM library.books_authors JOIN library.authors " +
                                "ON (books_authors.author_id=authors.author_id) WHERE book_id=?");
                statementAuthors.setInt(1, bookId);
                ResultSet resultAuthors = statementAuthors.executeQuery();
                List<Author> authors = new ArrayList<>();
                while (resultAuthors.next()) {
                    authors.add(new Author(resultAuthors.getInt(1), resultAuthors.getString(2)));
                }
                books.add(new Book(bookId, result.getString(2), authors));
            }
        } catch (SQLException e) {
            throw new DaoException("Can't get book list", e);
        }
        return books;
    }

}

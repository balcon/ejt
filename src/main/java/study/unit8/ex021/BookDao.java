package study.unit8.ex021;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private final ConnectionPool connectionPool;

    public BookDao() throws SQLException {
        connectionPool = new ConnectionPool(10);
    }

    public List<Book> getBooks() throws SQLException, IOException {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM books")) {
            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
            }
            return books;
        }
    }

    public int createBooks(List<Book> books) throws SQLException {
        int executeCounter = 0;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "insert into books (book_id,name,author) values(?,?,?)")) {
            for (Book book : books) {
                statement.setInt(1, book.getBookId());
                statement.setString(2, book.getName());
                statement.setString(3, book.getAuthor());
                executeCounter += statement.executeUpdate();
            }
        }
        return executeCounter;
    }
}

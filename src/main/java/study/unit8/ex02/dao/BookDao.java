package study.unit8.ex02.dao;

import study.unit8.ex02.Book;
import study.unit8.ex02.connections.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    ConnectionPool connectionPool;

    public BookDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public int createBook(Book book) throws SQLException  {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO library.books (book_id,name, author, book_year) VALUES (?,?,?,?)");
            statement.setInt(1, book.getId());
            statement.setString(2, book.getName());
            statement.setString(3, book.getAuthor());
            statement.setInt(4, book.getYear());
            return statement.executeUpdate();
        }
    }

    public List<Book> getBookList() throws SQLException {
        final List<Book> books=new ArrayList<>();
        try (Connection connection=connectionPool.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT name, author, book_year FROM library.books");
            while(result.next()){
                books.add(new Book(1, result.getString(1),result.getString(2),result.getInt(3)));
            }
        }
        return books;
    }

}

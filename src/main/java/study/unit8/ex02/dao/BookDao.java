package study.unit8.ex02.dao;

import study.unit8.ex02.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public int createBook(Book book) throws SQLException, ClassNotFoundException {
        try (Connection connection = DaoFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO books (name, author, book_year) VALUES (?,?,?)");
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            return statement.executeUpdate();
        }
    }

    public List<Book> getBookList() throws SQLException, ClassNotFoundException {
        final List<Book> books=new ArrayList<>();
        try (Connection connection=DaoFactory.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT name, author, book_year FROM books");
            while(result.next()){
                books.add(new Book(result.getString(1),result.getString(2),result.getInt(3)));
            }
        }
        return books;
    }

}

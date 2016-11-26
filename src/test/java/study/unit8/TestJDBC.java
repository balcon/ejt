package study.unit8;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Book{
    private final int id;
    private final String name;
    private final String author;
    private Integer currentUserId;

    public Book(int id, String name, String author, Integer currentUserId) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.currentUserId = currentUserId;
    }

    @Override
    public String toString() {
        return String.format("[%d][%s][%s][%d]",id,name,author,currentUserId);
    }
}
public class TestJDBC {
    private final String url="jdbc:mysql://localhost:3306/lib";
    private final String user="root";
    private final String pwd="54321qaz";
    List<Book> books=new ArrayList<>();
    @Test
    public void test1() throws Exception {

        try(Connection connection = DriverManager.getConnection(url, user, pwd)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            while(resultSet.next()){
                books.add(new Book(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4)));
            }
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

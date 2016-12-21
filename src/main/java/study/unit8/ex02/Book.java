package study.unit8.ex02;

import lombok.ToString;

import java.util.List;

@ToString
public class Book {
    private final int id;
    private final String name;
    private User currentUser;
    private List<Author> authors;

    public Book(int id, String name, List<Author> authors, User currentUser) {
        this.id = id;
        this.name = name;
        this.currentUser = currentUser;
        this.authors = authors;
    }

    public Book(int id, String name, List<Author> authors) {
        this.id = id;
        this.name = name;
        this.authors = authors;
    }

    public Book(int bookId, String name) {
        this.id=bookId;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}

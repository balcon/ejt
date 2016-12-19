package study.unit8.ex02;

public class Book {
    private final int id;
    private final String name;
    private final Author author;

    public Book(int id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }
}

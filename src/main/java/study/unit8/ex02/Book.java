package study.unit8.ex02;

public class Book {
    private final int id;
    private final String name;
    private final String author;
    private final int year;

    public Book(int id, String name, String author, int year) {
        this.id=id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }
}

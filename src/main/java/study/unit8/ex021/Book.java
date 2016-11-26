package study.unit8.ex021;

public class Book {

    private final int bookId;
    private final String name;
    private final String author;
    private final Integer currentUserId;

    public Book(int bookId, String name, String author, Integer currentUserId) {

        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.currentUserId = currentUserId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getCurrentUserId() {
        return currentUserId;
    }
}

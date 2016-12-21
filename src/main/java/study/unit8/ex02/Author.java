package study.unit8.ex02;

import lombok.ToString;

@ToString
public class Author {
    private final int id;
    private final String name;

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

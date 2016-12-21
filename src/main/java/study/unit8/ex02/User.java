package study.unit8.ex02;

import lombok.ToString;

@ToString
public class User {
    private final int id;
    private final String name;
    private final String phone;

    public User(int id, String name, String phone) {
        this.id = id;

        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}

package study.unit4.ex04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Movie implements Serializable {
    private static final long serialVersionUID = 1279987595383209241L;

    private String name;
    private String country;
    private int year;
    private List<String> actors = new ArrayList<>();

    public Movie(String name, String country, int year) {
        this.name = name;
        this.country = country;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void addActors(String... actor) {
        Collections.addAll(this.actors,actor);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", year=" + year +
                ", actors=" + actors +
                "}";
    }
}

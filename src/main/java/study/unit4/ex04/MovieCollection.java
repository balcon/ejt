package study.unit4.ex04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieCollection implements Serializable {
    private static final long serialVersionUID = 1716063777838096999L;

    private final List<Movie> movies = new ArrayList<>();// TODO: 31.10.2016 change List to Set

    public static MovieCollection deserializeFrom(String filePath) throws IOException, ClassNotFoundException {
        MovieCollection movieCollection;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            movieCollection = (MovieCollection) objectInputStream.readObject();
        }
        return movieCollection;
    }

    public void serializeTo(String filePath) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(this);
        }

    }

    public void addActors(String movieName, String... actors) {
        for (Movie movie : movies) {
            if(movie.getName().equals(movieName)){
                movie.addActors(actors);
            }
        }
    }

    public void addMovie(String name,String country,int year) {
        movies.add(new Movie(name,country,year));
    }

    public void removeMovie(String movieName) {
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getName()==movieName){
                movies.remove(i);
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder= new StringBuilder();
        for (Movie movie : movies) {
            stringBuilder.append(movie.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return  stringBuilder.toString();
    }
}

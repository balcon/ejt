package study.unit4.ex04;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.Serializable;

import static org.junit.Assert.*;

public class MovieCollectionTest {
    String filePath = "src\\main\\resources\\study\\unit4\\ex04\\storage.obj";
    MovieCollection movieCollection1 = new MovieCollection();

    @Before
    public void initObj() throws Exception {
        movieCollection1.addMovie("Saving Private Ryan", "USA", 1998);
        movieCollection1.addActors("Saving Private Ryan", "Tom Hanks", "Matt Damon");
        movieCollection1.addMovie("Forrest Gump", "USA", 1994);
        movieCollection1.addActors("Forrest Gump", "Toms Hanks", "Gary Sinise");
    }

    @Test
    public void isSerializible() throws Exception {
        assertTrue(movieCollection1 instanceof Serializable);
    }

    @Test
    public void testSerialize() throws Exception {
        movieCollection1.serializeTo(filePath);

        assertTrue(new File(filePath).exists());
    }

    @Test
    public void testDeserialize() throws Exception {
        MovieCollection movieCollection2;
        movieCollection1.serializeTo(filePath);
        movieCollection2 = MovieCollection.deserializeFrom(filePath);

        assertEquals(movieCollection1, movieCollection2);
    }

    @Test
    public void removeMove() throws Exception {
        MovieCollection movieCollection3 = movieCollection1;
        movieCollection1.removeMovie("Forrest Gump");

        assertFalse(movieCollection3.equals(movieCollection1));

    }
}

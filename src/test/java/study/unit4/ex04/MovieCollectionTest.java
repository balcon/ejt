package study.unit4.ex04;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertTrue;

public class MovieCollectionTest {
    String filePath = "src\\main\\resources\\study\\unit4\\ex04\\storage.obj";
    MovieCollection movieCollection1 = new MovieCollection();
    MovieCollection movieCollection2 = new MovieCollection();

    @Before
    public void initObj() throws Exception {

        movieCollection1.addMovie("Saving Private Ryan", "USA", 1998);
        movieCollection1.addActors("Saving Private Ryan", "Tom Hanks", "Matt Damon");
        movieCollection1.addMovie("Forrest Gump","USA",1994);
        movieCollection1.addActors("Forrest Gump","Toms Hanks","Gary Sinise");
    }

    @Test
    public void isSerializible() throws Exception {
        assertTrue(movieCollection1 instanceof Serializable);
    }


    @Test
    public void testSerialize() throws Exception {
        movieCollection1.serializeTo(filePath);
    }

    @Test
    public void testToString() throws Exception {
        System.out.println("Test toString()");
        System.out.println(movieCollection1);
    }

    @Test
    public void testDeserialize() throws Exception {
        System.out.println("ToString after deserialize");
        movieCollection2 = MovieCollection.deserializeFrom(filePath);
        System.out.println(movieCollection2);
    }

    @Test
    public void removeMove() throws Exception {
        System.out.println("Remove movie");
        movieCollection1.removeMovie("Forrest Gump");
        System.out.println(movieCollection1);

    }
}

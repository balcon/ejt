package study.unit1.ex06;

import org.junit.Test;

import static org.junit.Assert.*;

public class NotepadTest {

    NoteBook redBook = new NoteBook(3);

    @Test
    public void test() {

        redBook.createNote("record #1");
        redBook.createNote("record #2");
        redBook.createNote("record #3");
        redBook.createNote("record #4");

        redBook.showAllNotes();

        //- NoteBook -
        //0. record #1
        //1. record #2
        //2. record #3
        //3. record #4

        redBook.removeNote(1);
        redBook.showAllNotes();

        //- NoteBook -
        //0. record #1
        //2. record #3
        //3. record #4

        redBook.editNote(1, "2nd record");
        redBook.editNote(2, "3rd record");
        redBook.showAllNotes();

        //- NoteBook -
        //0. record #1
        //1. 2nd record
        //2. 3rd record

        redBook.trimToSize();
        redBook.showAllNotes();

        //- NoteBook -
        //0. record #1
        //1. 2nd record
        //2. 3rd record

    }


}
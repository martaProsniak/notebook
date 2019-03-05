package pl.mp.notebook.model;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class DisplayNotebookTest {

    Note note1, note2;
    List<Note> noteList = new ArrayList<>(0);
    DisplayStrategy displayStrategy;

    @Before
    public void prepare() {
        note1 = new Note();
        note1.setTitle("a");
        note1.setAuthor("b");
        note1.setText("ccc ccc");
        note1.setDate("1990/01/01 00:00:01");
        noteList.add(note1);

        note2 = new Note();
        note2.setTitle("d");
        note2.setAuthor("b");
        note2.setText("ddd ddd");
        note2.setDate("1991/01/01 00:00:01");
        noteList.add(note2);
    }


    @Test
    public void testSimpleDisplay() {
        displayStrategy = new FullDisplayStrategy();
        DisplayNotebook displayNotebook = new DisplayNotebook(noteList, displayStrategy);

        String notes = noteList.stream().map(note -> note + "\r\n").collect(Collectors.joining());

        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        displayNotebook.displayNotes();
        boolean test = notes.contentEquals(os.toString());

        assertTrue(test);

        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }
}

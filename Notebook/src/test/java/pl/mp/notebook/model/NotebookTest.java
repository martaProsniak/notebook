package pl.mp.notebook.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NotebookTest {

    Note note1, note2, note3;
    Notebook notebook;

    @Before
    public void prepare() {
        note1 = new Note();
        note2 = new Note();
        note3 = new Note();
        notebook = Notebook.getInstance();
    }

    @Test
    public void addTestWhenNoteNotNull(){
        notebook.add(note1);
        assertTrue(notebook.getAll().contains(note1));
    }

    @Test
    public void addTestWhenNoteNull(){
        Note noteNull = null;
        notebook.add(noteNull);
        assertFalse(notebook.getAll().contains(noteNull));
    }

    @Test
    public void addTestWhenMoreNotes(){
        notebook.add(note1);
        notebook.add(note2);
        notebook.add(note3);

        assertTrue(notebook.getAll().size() == 3);
    }

}

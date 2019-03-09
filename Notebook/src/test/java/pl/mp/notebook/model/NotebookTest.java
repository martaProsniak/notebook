package pl.mp.notebook.model;

import org.junit.Before;
import org.junit.Test;


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
    public void addTestWhenNoteNull(){
        notebook.add(null);
        assertTrue(notebook.getAll().isEmpty());
    }

    @Test
    public void addTestWhenNoteNotNull(){
        note1.setTitle("a");
        note1.setAuthor("b");
        note1.setText("ccc ccc");
        note1.setDate("1990/01/01 00:00:01");

        notebook.add(note1);

        assertTrue(notebook.getAll().contains(note1));
    }

    @Test
    public void addTestWhenMoreNotes(){
        notebook.add(note1);
        notebook.add(note2);
        notebook.add(note3);

        assertTrue(notebook.getAll().size() == 3);
    }

}

package pl.mp.notebook.model;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class NotebookBuilderTest {

    Note note1;

    @Before
    public void prepare(){
        note1 = new Note();
        note1.setTitle("a");
        note1.setAuthor("b");
        note1.setText("ccc ccc");
        note1.setDate("1990/01/01 00:00:01");
    }

    @Test
    public void testNoteWhenCreated(){
        String title = "a";
        String author = "b";
        String text = "ccc ccc";
        String date = "1990/01/01 00:00:01";
        NoteBuilder noteBuilder = new NoteBuilder();

        noteBuilder.withTitle(title)
                .withAuthor(author)
                .withText(text)
                .withDate(date);

        Note testNote = noteBuilder.build();

        assertEquals(note1, testNote);
    }

    @Test
    public void testNoteWhenAuthorNotProvided(){
        String title = "a";
        String author = null;
        String text = "ccc ccc";
        String date = "1990/01/01 00:00:01";
        NoteBuilder noteBuilder = new NoteBuilder();

        noteBuilder.withTitle(title)
                .withAuthor(author)
                .withText(text)
                .withDate(date);

        Note testNote = noteBuilder.build();

        assertTrue(testNote.getAuthor() == null);
    }




}

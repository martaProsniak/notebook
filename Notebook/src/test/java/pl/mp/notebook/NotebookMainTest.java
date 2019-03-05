package pl.mp.notebook;

import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Not;
import org.powermock.core.classloader.annotations.PrepareForTest;
import pl.mp.notebook.model.Note;
import pl.mp.notebook.model.NoteBuilder;
import pl.mp.notebook.model.Notebook;

@PrepareForTest(Notebook.class)
public class NotebookMainTest {


    Notebook notebook = Notebook.getInstance();
    Note note1, note2, note3;

    @Before
    public void prepare(){
        note1 = new Note();
        note1.setTitle("a");
        note1.setAuthor("b");
        note1.setText("ccc ccc");
        note1.setDate("1990/01/01 00:00:01");
        note2 = new Note();
        note3 = new Note();
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

}

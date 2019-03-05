package pl.mp.notebook.model;

import java.util.List;

public class DisplayNotebook {

    private List<Note> noteList;

    private DisplayStrategy displayStrategy;

    public DisplayNotebook(List<Note> noteList, DisplayStrategy displayStrategy) {
        this.noteList = noteList;
        this.displayStrategy = displayStrategy;
    }

    public void displayNotes() {
        displayStrategy.display(noteList);
    }
}

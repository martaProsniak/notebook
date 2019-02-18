package pl.mp.notebook.model;


import java.util.List;

public class SimpleDisplayStrategy implements DisplayStrategy {

    @Override
    public void display(List<Note> notes) {
        notes.stream()
                .map(note -> note.getTitle() + "; author: " + note.getAuthor())
                .forEach(System.out::println);
    }
}

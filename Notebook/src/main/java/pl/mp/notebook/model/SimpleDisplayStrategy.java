package pl.mp.notebook.model;


import java.util.List;

public class SimpleDisplayStrategy implements DisplayStrategy {

    @Override
    public void display(List<Note> notes) {
        notes.stream()
                .map(note -> "Author: " + note.getAuthor() + "; " + note.getTitle())
                .forEach(System.out::println);
    }
}

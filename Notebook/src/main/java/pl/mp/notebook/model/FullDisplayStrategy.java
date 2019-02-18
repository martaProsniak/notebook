package pl.mp.notebook.model;

import java.util.List;

public class FullDisplayStrategy implements DisplayStrategy {

    @Override
    public void display(List<Note> notes) {
        notes.forEach(System.out::println);
    }
}

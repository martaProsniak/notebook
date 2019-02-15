package pl.mp.notebook.model;

import java.util.ArrayList;
import java.util.List;

public class Notebook implements NoteStorage {

    private List<Note> noteList = new ArrayList<>();

    @Override
    public void add(Note note) {
        if (note == null){
            throw new RuntimeException();
        }
        noteList.add(note);
    }

    @Override
    public void display() {
        noteList.forEach(System.out::println);
    }

    @Override
    public List<Note> filter(List<Note> notes) {
        return null;
    }

    @Override
    public boolean remove(Note note) {
        return false;
    }
}


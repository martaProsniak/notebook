package pl.mp.notebook.model;

import java.util.ArrayList;
import java.util.List;

public class Notebook implements NoteStorage {

    private List<Note> noteStorage= new ArrayList<>();


    @Override
    public void add(Note note) {
        if (note == null){
            throw new RuntimeException();
        }
        noteStorage.add(note);
    }

    @Override
    public List<Note> filter(List<Note> notes) {
        return null;
    }

    @Override
    public boolean remove(Note note) {
        return noteStorage.remove(note);
    }

    @Override
    public List<Note> getAll() {
        List<Note> noteList = new ArrayList<>();
        noteList.addAll(noteStorage);
        return noteList;
    }
}


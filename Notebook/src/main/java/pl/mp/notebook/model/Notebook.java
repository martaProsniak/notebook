package pl.mp.notebook.model;

import java.util.ArrayList;
import java.util.List;

public class Notebook implements NoteStorage {

    public static Notebook notebook = new Notebook();

    public static Notebook getInstance(){
        return notebook;
    }

    private Notebook(){
    }

    private List<Note> noteStorage= new ArrayList<>();


    @Override
    public void add(Note note) {
        if (note == null){
            System.out.println("Note not added!");
        } else {
            noteStorage.add(note);
        }
    }

    @Override
    public boolean remove(List<Note> notes) {
        if (notes.isEmpty()){
            throw new RuntimeException();
        } else {
            return noteStorage.removeAll(notes);
        }
    }

    @Override
    public List<Note> getAll() {
        List<Note> noteList = new ArrayList<>();
        noteList.addAll(noteStorage);
        return noteList;
    }
}


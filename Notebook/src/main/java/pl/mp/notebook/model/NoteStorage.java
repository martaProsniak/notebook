package pl.mp.notebook.model;


import java.util.List;

public interface NoteStorage {

    public void add (Note note);

    public boolean remove (List<Note>notes);

    public List<Note> getAll();

}

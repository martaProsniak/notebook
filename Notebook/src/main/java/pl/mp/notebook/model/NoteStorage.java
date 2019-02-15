package pl.mp.notebook.model;


import java.util.List;

public interface NoteStorage {

    public void add (Note note);

    public List<Note> filter (List<Note> notes);

    public boolean remove (Note note);

    public List<Note> getAll();

}

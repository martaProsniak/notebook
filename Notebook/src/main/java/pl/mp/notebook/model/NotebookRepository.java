package pl.mp.notebook.model;


import java.util.List;

public interface NotebookRepository {

    public void add (Note note);

    public void display (List<Note> notes);

    public List<Note> filter (List<Note> notes);

    public boolean remove (Note note);

}

package pl.mp.notebook.model;

import java.util.List;

public class Notebook implements NotebookRepository {

    private NotebookRepository notebookRepository;

    @Override
    public void add(Note note) {
        notebookRepository.add(note);
    }

    @Override
    public void display(List<Note> notes) {

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

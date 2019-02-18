package pl.mp.notebook.model;


public class SimpleDisplayStrategy implements DisplayStrategy {

    @Override
    public void display(Notebook notebook) {
        notebook.getAll().stream()
                .map(note -> note.getTitle() + "; author: " + note.getAuthor())
                .forEach(System.out::println);
    }
}

package pl.mp.notebook.model;

public class FullDisplayStrategy implements DisplayStrategy {

    @Override
    public void display(Notebook notebook) {
        notebook.getAll().forEach(System.out::println);
    }
}

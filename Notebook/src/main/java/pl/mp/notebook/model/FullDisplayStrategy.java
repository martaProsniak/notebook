package pl.mp.notebook.model;


public class FullDisplayStrategy implements DisplayStrategy {

    @Override
    public void display(Notebook notebook) {
        notebook.getAll()
                .stream()
                .forEach(System.out::println);
    }
}

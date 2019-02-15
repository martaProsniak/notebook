package pl.mp.notebook.model;


public class FilterApplier {

    private Notebook notebook;

    private Filter filter;

    public FilterApplier(Notebook notebook, Filter filter){
        this.notebook = notebook;
        this.filter= filter;
    }

    public void setFilter() {
        notebook.getAll().stream()
                .filter(note -> note.getTitle().contains(filter.getTitleFilter())
                        && note.getAuthor().equals(filter.getAuthorFilter())
                        && note.getText().contains(filter.getTextFilter()))
                .forEach(System.out::println);
    }

}

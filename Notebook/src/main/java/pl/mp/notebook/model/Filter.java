package pl.mp.notebook.model;

public class Filter {

    private String titleFilter;

    private Author authorFilter;

    private String textFilter;

    public String getTitleFilter() {
        return titleFilter;
    }

    public void setTitleFilter(String titleFilter) {
        this.titleFilter = titleFilter;
    }

    public Author getAuthorFilter() {
        return authorFilter;
    }

    public void setAuthorFilter(Author authorFilter) {
        this.authorFilter = authorFilter;
    }

    public String getTextFilter() {
        return textFilter;
    }

    public void setTextFilter(String textFilter) {
        this.textFilter = textFilter;
    }

}

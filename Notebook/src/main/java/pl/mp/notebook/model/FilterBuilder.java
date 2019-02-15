package pl.mp.notebook.model;

public class FilterBuilder {

    private String titleFilter;

    private String authorNameFilter;

    private String authorSurnameFilter;

    private String textFilter;

    public FilterBuilder withTitle(String title) {
        this.titleFilter = title;
        return this;
    }

    public FilterBuilder withAuthorName(String authorName) {
        this.authorNameFilter = authorName;
        return this;
    }

    public FilterBuilder withAuthorSurname(String authorSurnameFilter) {
        this.authorSurnameFilter = authorSurnameFilter;
        return this;
    }

    public FilterBuilder withText(String text) {
        this.textFilter = text;
        return this;
    }

    public Filter build() {
        Filter filter = new Filter();
        filter.setTextFilter(textFilter);
        Author author = new Author();
        author.setName(authorNameFilter);
        author.setSurname(authorSurnameFilter);
        filter.setAuthorFilter(author);
        filter.setTitleFilter(titleFilter);
        return filter;
    }
}

package pl.mp.notebook.model;

public class FilterBuilder {

    private String titleToFilter;

    private String authorToFilter;

    private String textToFilter;

    public FilterBuilder withTitle(String title) {
        this.titleToFilter = title;
        return this;
    }

    public FilterBuilder withAuthor(String author) {
        this.authorToFilter = author;
        return this;
    }

    public FilterBuilder withText(String text) {
        this.textToFilter = text;
        return this;
    }

    public Filter build() {
        Filter filter = new Filter();
        filter.setTextToFilter(textToFilter);
        filter.setAuthorToFilter(authorToFilter);
        filter.setTitleToFilter(titleToFilter);
        return filter;
    }
}

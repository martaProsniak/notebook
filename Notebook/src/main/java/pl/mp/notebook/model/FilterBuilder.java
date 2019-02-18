package pl.mp.notebook.model;

public class FilterBuilder {

    private String titleToFilter;

    private String authorNameToFilter;

    private String authorSurnameToFilter;

    private String textToFilter;

    public FilterBuilder withTitle(String title) {
        this.titleToFilter = title;
        return this;
    }

    public FilterBuilder withAuthorName(String authorName) {
        this.authorNameToFilter = authorName;
        return this;
    }

    public FilterBuilder withAuthorSurname(String authorSurnameFilter) {
        this.authorSurnameToFilter = authorSurnameFilter;
        return this;
    }

    public FilterBuilder withText(String text) {
        this.textToFilter = text;
        return this;
    }

    public Filter build() {
        Filter filter = new Filter();
        filter.setTextToFilter(textToFilter);
        Author author = new Author();
        author.setName(authorNameToFilter);
        author.setSurname(authorSurnameToFilter);
        filter.setAuthorToFilter(author);
        filter.setTitleToFilter(titleToFilter);
        return filter;
    }
}

package pl.mp.notebook.model;

public class Filter {

    private String titleToFilter;

    private String authorToFilter;

    private String textToFilter;

    public String getTitleToFilter() {
        return titleToFilter;
    }

    public void setTitleToFilter(String titleToFilter) {
        this.titleToFilter = titleToFilter;
    }

    public String getAuthorToFilter() {
        return authorToFilter;
    }

    public void setAuthorToFilter(String authorToFilter) {
        this.authorToFilter = authorToFilter;
    }

    public String getTextToFilter() {
        return textToFilter;
    }

    public void setTextToFilter(String textToFilter) {
        this.textToFilter = textToFilter;
    }

}

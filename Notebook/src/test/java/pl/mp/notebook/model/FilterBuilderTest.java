package pl.mp.notebook.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FilterBuilderTest {

    Filter filter1;

    @Before
    public void prepare() {
        filter1 = new Filter();
        filter1.setAuthorToFilter("b");
        filter1.setTextToFilter("ccc ccc");
        filter1.setTitleToFilter("a");
    }

    @Test
    public void testFilterWhenCreated(){
        String title = "a";
        String author = "b";
        String text = "ccc ccc";
        FilterBuilder filterBuilder = new FilterBuilder();

        filterBuilder.withTitle(title)
                .withAuthor(author)
                .withText(text);

        Filter testFilter = filterBuilder.build();

        assertEquals(filter1.getAuthorToFilter(), testFilter.getAuthorToFilter());
        assertEquals(filter1.getTextToFilter(), testFilter.getTextToFilter());
        assertEquals(filter1.getTitleToFilter(), testFilter.getTitleToFilter());
    }

}

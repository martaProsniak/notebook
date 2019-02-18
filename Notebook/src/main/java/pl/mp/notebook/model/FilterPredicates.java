package pl.mp.notebook.model;

import java.util.function.Predicate;

public class FilterPredicates {

    private Filter filter;

    public static Predicate<Note> filterTitle (Filter filter) {
        return n -> n.getTitle().equalsIgnoreCase(filter.getTitleFilter());
    }

}

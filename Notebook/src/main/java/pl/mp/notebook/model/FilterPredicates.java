package pl.mp.notebook.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterPredicates {

   /* public static Predicate<Note> filterByTitle (Filter filter) {
        return p -> p.getTitle().equalsIgnoreCase(filter.getTitleToFilter());
    }

    public static Predicate<Note> filterByAuthor(Filter filter){
        return p -> p.getAuthor().equals(filter.getAuthorToFilter());
    }

    public static Predicate<Note> filterByText(Filter filter){
        return p -> p.getText().equalsIgnoreCase(filter.getTextToFilter());
    }

    public static Predicate<Note> filterByTitleAndAuthor(Filter filter){
        return p -> p.getTitle().equalsIgnoreCase(filter.getTextToFilter()) &&
                p.getAuthor().equals(filter.getAuthorToFilter());
    }

    public static Predicate<Note> filterByTitleAndText (Filter filter){
        return p -> p.getTitle().equalsIgnoreCase(filter.getTitleToFilter()) &&
                p.getText().equalsIgnoreCase(filter.getTextToFilter());
    }

    public static Predicate<Note> filterByAuthorAndText (Filter filter){
        return p -> p.getAuthor().equals(filter.getAuthorToFilter()) &&
                p.getText().equalsIgnoreCase(filter.getTextToFilter());
    }*/

    public static Predicate<Note> filterBuild(Filter filter){
        return p -> (p.getText().equalsIgnoreCase(filter.getTextToFilter()) || filter.getTextToFilter() == null) &&
                (p.getAuthor().equals(filter.getAuthorToFilter()) || filter.getAuthorToFilter() == null) &&
                (p.getTitle().equalsIgnoreCase(filter.getTitleToFilter()) || filter.getTitleToFilter() == null);
    }

    public static List<Note> filterNotesList(List<Note> notes, Predicate<Note> filterPredicate){
        return notes.stream()
                .filter(filterPredicate)
                .collect(Collectors.toList());
    }

}

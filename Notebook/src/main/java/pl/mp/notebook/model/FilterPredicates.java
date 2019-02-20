package pl.mp.notebook.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterPredicates {

    public static Predicate<Note> createFilter(Filter filter){
        return p -> (p.getText().equalsIgnoreCase(filter.getTextToFilter()) || filter.getTextToFilter() == null) &&
                (p.getAuthor().equals(filter.getAuthorToFilter()) || filter.getAuthorToFilter() == null) &&
                (p.getTitle().equalsIgnoreCase(filter.getTitleToFilter()) || filter.getTitleToFilter() == null);
    }

    public static List<Note> compareNotes(List<Note> notes, Predicate<Note> filterPredicate){
        return notes.stream()
                .filter(filterPredicate)
                .collect(Collectors.toList());
    }

}

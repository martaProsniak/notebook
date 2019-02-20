package pl.mp.notebook;

import pl.mp.notebook.model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static pl.mp.notebook.model.FilterPredicates.*;

public class NotebookMain {

    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {

        Notebook notebook = new Notebook();

        boolean running = true;

        printMenu();

        while (running) {

            String command;

            command = inputScanner.next().toUpperCase();

            switch (command) {
                case ("A"): {
                    notebook.add(addNote());
                    break;
                }
                case ("D"): {
                    display(notebook.getAll(), chooseDisplayWay());
                    break;
                }
                case ("F"): {
                    List <Note> filteredNotes = filterNotes(notebook);
                    display(filteredNotes, chooseDisplayWay());
                    break;
                }
                case ("R"): {
                    removeNotes(notebook);
                    break;
                }
                case ("Q"): {
                    running = false;
                    break;
                }
                default: {
                    printMenu();
                    break;
                }

            }

        }
    }

    public static void printMenu() {
        System.out.println("Choose action: \n" +
                "A - Add new note \n" +
                "D - Display note \n" +
                "F - Filter notes \n" +
                "R - Remove note \n" +
                "Q - Quit program");
    }

    public static Note addNote() {
        System.out.print("Enter title: ");
        String title = inputScanner.next();
        System.out.print("Enter author : ");
        String author = inputScanner.next();
        System.out.print("Enter text: ");
        String text = inputScanner.next();

        NoteBuilder noteBuilder = new NoteBuilder();

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        String dateText = dateFormat.format(date);
        noteBuilder.withTitle(title)
                .withAuthor(author)
                .withText(text)
                .withDate(dateText);
        Note note = noteBuilder.build();

        if (note != null) {
            System.out.println("Note added!");
        }
        return note;
    }

    public static String chooseDisplayWay(){
        System.out.println("How to display notes? \n" +
                "Short - simple display (title and author) \n" +
                "All - full display");
        String displayWay = inputScanner.next().toUpperCase();
        return displayWay;
    }

    public static void display(List<Note> notesList, String displayWay) {

        switch (displayWay) {
            case ("SHORT"): {
                DisplayStrategy displayStrategy = new SimpleDisplayStrategy();
                DisplayNotebook displayNotebook = new DisplayNotebook(notesList, displayStrategy);
                displayNotebook.displayNotes();
                break;
            }
            case ("ALL"): {
                DisplayStrategy displayStrategy = new FullDisplayStrategy();
                DisplayNotebook displayNotebook = new DisplayNotebook(notesList, displayStrategy);
                displayNotebook.displayNotes();
                break;
            }
            default: {
                System.out.println("Choose valid command!");
                break;
            }
        }

    }

    public static Filter chooseFilter() {
        String title;
        String author;
        String text;
        String command;

        System.out.println("Filter by title (y/n): ");
        command = inputScanner.next();
        if (command.equals("y")) {
            System.out.println("Enter title to be filtered:");
            title = inputScanner.next();
        } else title = null;

        System.out.println("Filter by author (y/n): ");
        command = inputScanner.next();
        if (command.equals("y")) {
            System.out.println("Enter author to be filtered:");
            author = inputScanner.next();
        } else {
            author = null;
        }

        System.out.println("Filter by text (y/n): ");
        command = inputScanner.next();
        if (command.equals("y")) {
            System.out.println("Enter text to be filtered:");
            text = inputScanner.next();
        } else text = null;

        if ((title == null) && (author == null) && (text == null)) {
            return new Filter();
        } else {
            FilterBuilder filterBuilder = new FilterBuilder();
            filterBuilder.withTitle(title).withAuthor(author).withText(text);
            Filter filter = filterBuilder.build();
            return filter;
        }
    }

    public static List<Note> filterNotes (Notebook notebook){
        Filter filter = chooseFilter();
        return compareNotes(notebook.getAll(), createFilter(filter));
    }

    public static boolean removeNotes (Notebook notebook){
        List <Note> filteredNotes = filterNotes(notebook);
        String displayWay = "SHORT";
        display(filteredNotes, displayWay);
        System.out.println("Press Y to confirm removal");
        String confirmation = inputScanner.next();
        if (confirmation.equalsIgnoreCase("y")){
            notebook.remove(filteredNotes);
            System.out.println("Notes removed!");
            return true;
        } else {
            System.out.println("Operation cancelled!");
            return false;
        }
    }

}




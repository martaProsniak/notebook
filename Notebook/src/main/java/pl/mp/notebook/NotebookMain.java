package pl.mp.notebook;

import pl.mp.notebook.model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import static pl.mp.notebook.model.FilterPredicates.*;

public class NotebookMain {

    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {

        Notebook notebook = new Notebook();

        boolean running = true;

        printMenu();

        while (running) {

            int command = inputScanner.nextInt();

            switch (command) {
                case 1: {
                    notebook.add(addNote());
                    break;
                }
                case 2: {
                    display(notebook);
                    break;
                }
                case 3: {
                    Filter filter = chooseFilter();
                    System.out.println(filterNotes(notebook.getAll(), filterByAll(filter)));
                    break;
                }
                case 4: {

                    break;
                }
                case 5: {
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
                "1 - Add new note \n" +
                "2 - Display note \n" +
                "3 - Filter notes \n" +
                "4 - Remove note \n" +
                "5 - Quit program");
    }

    public static Note addNote() {
        System.out.print("Enter title: ");
        String title = inputScanner.next();
        System.out.print("Enter author name: ");
        String authorName = inputScanner.next();
        System.out.print("Enter author surname: ");
        String authorSurname = inputScanner.next();
        System.out.print("Enter text: ");
        String text = inputScanner.next();

        NoteBuilder noteBuilder = new NoteBuilder();

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        String dateText = dateFormat.format(date);
        noteBuilder.withTitle(title)
                .withAuthorName(authorName)
                .withAuthorSurname(authorSurname)
                .withText(text)
                .withDate(dateText);
        Note note = noteBuilder.build();

        if (note != null) {
            System.out.println("Note added!");
        }
        return note;
    }

    public static void display(Notebook notebook) {
        System.out.println("How to display notes? \n" +
                "1 - simple display (title and author) \n" +
                "2 - full display");

        int command = inputScanner.nextInt();

        switch (command) {
            case 1: {
                DisplayStrategy displayStrategy = new SimpleDisplayStrategy();
                DisplayNotebook displayNotebook = new DisplayNotebook(notebook, displayStrategy);
                displayNotebook.displayNotes();
                break;
            }
            case 2: {
                DisplayStrategy displayStrategy = new FullDisplayStrategy();
                DisplayNotebook displayNotebook = new DisplayNotebook(notebook, displayStrategy);
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
        String authorName;
        String authorSurname;
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
            System.out.println("Enter author name to be filtered:");
            authorName = inputScanner.next();
            System.out.println("Enter author surname to be filtered:");
            authorSurname = inputScanner.next();
        } else  {
            authorName = null;
            authorSurname = null;
        }

        System.out.println("Filter by text (y/n): ");
        command = inputScanner.next();
        if (command.equals("y")) {
            System.out.println("Enter text to be filtered:");
            text = inputScanner.next();
        } else text = null;

        if (title == null && authorName == null && authorSurname == null && text == null){
            return new Filter();
        } else{
            FilterBuilder filterBuilder = new FilterBuilder();
            filterBuilder.withTitle(title)
                    .withAuthorName(authorName)
                    .withAuthorSurname(authorSurname)
                    .withText(text);
            Filter filter = filterBuilder.build();
            return filter;
        }
    }




}




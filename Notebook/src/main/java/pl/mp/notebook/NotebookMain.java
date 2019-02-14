package pl.mp.notebook;

import pl.mp.notebook.model.Note;
import pl.mp.notebook.model.NoteBuilder;
import pl.mp.notebook.model.Notebook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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

                    break;
                }
                case 3: {

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

    public static void printMenu(){
        System.out.println("Choose action: \n" +
                "1 - Add new note \n" +
                "2 - Display note \n" +
                "3 - Filter notes \n" +
                "4 - Remove note \n" +
                "5 - Quit program");
    }

    public static Note addNote(){
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


}

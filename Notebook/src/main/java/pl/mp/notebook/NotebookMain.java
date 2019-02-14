package pl.mp.notebook;

import java.util.Scanner;

public class NotebookMain {

    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        printMenu();

        while (running) {

            int command = inputScanner.nextInt();

            switch (command) {
                case 1: {

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


}

package org.example;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * FileManager is the main class for running the file management application.
 * It displays the menu and delegates operations to the appropriate handlers.
 */
public class FileManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FileOperations fileOperations = new FileOperations();
    private static final DirectoryOperations directoryOperations = new DirectoryOperations();

    public static void main(String[] args) {
        System.out.println("Welcome to the File Manager!");
        while (true) {
            displayMenu();
            int choice = getMenuChoice();

            try {
                switch (choice) {
                    case 1: directoryOperations.listDirectory(); break;
                    case 2: fileOperations.copyFile(); break;
                    case 3: fileOperations.moveFile(); break;
                    case 4: fileOperations.deleteFile(); break;
                    case 5: fileOperations.searchFiles(); break;
                    case 6: directoryOperations.createDirectory(); break;
                    case 7: directoryOperations.deleteDirectory(); break;
                    case 8:
                        System.out.println("Thank you for using File Manager. Goodbye!");
                        return;
                    default: System.out.println("Invalid option. Please try again.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
                System.out.println("Please try again or choose a different operation.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- File Manager Menu ---");
        System.out.println("1. List Directory");
        System.out.println("2. Copy File");
        System.out.println("3. Move File");
        System.out.println("4. Delete File");
        System.out.println("5. Search Files");
        System.out.println("6. Create Directory");
        System.out.println("7. Delete Directory");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getMenuChoice() {
        int choice = -1;
        while (choice < 1 || choice > 8) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 8.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        return choice;
    }
}

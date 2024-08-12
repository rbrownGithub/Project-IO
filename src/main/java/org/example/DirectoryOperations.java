package org.example;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * DirectoryOperations handles directory-related operations like listing, creating, and deleting.
 */
public class DirectoryOperations {
    private static final Scanner scanner = new Scanner(System.in);

    public void listDirectory() throws IOException {
        System.out.print("Enter directory path to list: ");
        Path dir = Paths.get(scanner.nextLine());
        if (Files.exists(dir) && Files.isDirectory(dir)) {
            try (Stream<Path> stream = Files.list(dir)) {
                stream.forEach(System.out::println);
            }
            System.out.println("Directory listing complete.");
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }

    public void createDirectory() throws IOException {
        System.out.print("Enter path of directory to create (Include the name of directory): ");
        Path dir = Paths.get(scanner.nextLine());
        if (Files.exists(dir)) {
            System.out.println("Directory already exists.");
        } else {
            Files.createDirectory(dir);
            System.out.println("Directory created successfully.");
        }
    }

    public void deleteDirectory() throws IOException {
        System.out.print("Enter path of directory to delete: ");
        Path dir = Paths.get(scanner.nextLine());
        if (Files.exists(dir) && Files.isDirectory(dir)) {
            try (Stream<Path> stream = Files.list(dir)) {
                if (stream.findAny().isEmpty()) {
                    Files.delete(dir);
                    System.out.println("Directory deleted successfully.");
                } else {
                    System.out.println("Directory is not empty. Cannot delete.");
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }
}

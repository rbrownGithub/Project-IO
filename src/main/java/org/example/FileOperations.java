package org.example;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * FileOperations handles file-related operations like copy, move, delete, and search.
 */
public class FileOperations {
    private static final Scanner scanner = new Scanner(System.in);

    public void copyFile() throws IOException {
        System.out.print("Enter source file path: ");
        Path source = Paths.get(scanner.nextLine());
        System.out.print("Enter destination file path (including filename): ");
        Path dest = Paths.get(scanner.nextLine());

        if (Files.exists(source) && Files.isRegularFile(source)) {
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");
        } else {
            System.out.println("Source file does not exist or is not a file.");
        }
    }

    public void moveFile() throws IOException {
        System.out.print("Enter source file path: ");
        Path source = Paths.get(scanner.nextLine());
        System.out.print("Enter destination file path (including filename): ");
        Path dest = Paths.get(scanner.nextLine());

        if (Files.exists(source) && Files.isRegularFile(source)) {
            if (Files.isDirectory(dest)) {
                System.out.println("Destination path must include a filename.");
            } else {
                Files.move(source, dest, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File moved successfully.");
            }
        } else {
            System.out.println("Source file does not exist or is not a file.");
        }
    }

    public void deleteFile() throws IOException {
        System.out.print("Enter path of file to delete: ");
        Path file = Paths.get(scanner.nextLine());
        if (Files.exists(file) && Files.isRegularFile(file)) {
            Files.delete(file);
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("File does not exist or is not a file.");
        }
    }

    public void searchFiles() throws IOException {
        System.out.print("Enter directory path to search: ");
        Path dir = Paths.get(scanner.nextLine());
        System.out.print("Enter file name or extension to search for: ");
        String searchTerm = scanner.nextLine();

        if (Files.exists(dir) && Files.isDirectory(dir)) {
            try (Stream<Path> stream = Files.walk(dir)) {
                stream.filter(p -> p.getFileName().toString().contains(searchTerm))
                        .forEach(System.out::println);
            }
            System.out.println("Search complete.");
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }
}

package oops.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileReaderWriter {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new FileReaderWriter().startProgram();
    }

    public void startProgram() {
        FileOperation fileOperation = this.getFileOperation();
        switch (fileOperation) {
            case READ -> this.readFile();
            case WRITE -> this.writeToFile();
            case APPEND -> this.appendToFile();
        }
    }

    private FileOperation getFileOperation() {
        FileOperation fileOperation;
        System.out.println("Select a file operation: (r)ead, (w)rite, (a)ppend");
        while (true) {
            String input = this.scanner.nextLine();
            try {
                fileOperation = parseFileOperation(input.toLowerCase());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid operation (r, w, a)");
            }
        }
        return fileOperation;
    }

    private FileOperation parseFileOperation(String input) throws InputMismatchException {
        return switch (input) {
            case "r" -> FileOperation.READ;
            case "w" -> FileOperation.WRITE;
            case "a" -> FileOperation.APPEND;
            default -> throw new InputMismatchException();
        };
    }

    private Path getFilePath() {
        System.out.println("Enter the file name");
        String fileName = scanner.nextLine();
        return Paths.get(fileName);
    }

    private StringBuffer getFileContent() {
        System.out.println(("Enter the file content (use double enter to exit)"));
        StringBuffer fileContent = new StringBuffer();
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            fileContent.append(input);
            fileContent.append("\n");
        }
        return fileContent;
    }

    private void readFile() {
        while (true) {
            try {
                Path fileName = this.getFilePath();
                String fileContent = Files.readString(fileName);
                System.out.println("File content:\n");
                System.out.println(fileContent);
                break;
            } catch (IOException e) {
                System.out.println("The provided file name cannot be read.");
                System.out.println("Please make sure that the file exists and is readable.");
            }
        }
    }

    private void writeToFile() {
        Path fileName = this.getFilePath();
        if (!Files.exists(fileName)) {
            System.out.println("This file does not exist yet and will be created");
        }
        StringBuffer fileContent = this.getFileContent();
        try {
            Files.writeString(fileName, fileContent, StandardOpenOption.CREATE);
            System.out.println("The file was written successfully");
        } catch (IOException e) {
            this.displayWriteErrorMessage();
        }
    }

    private void appendToFile() {
        Path fileName = this.getFilePath();
        while (!Files.exists(fileName)) {
            System.out.println("This file does not exist. Please provide a valid file.");
            fileName = this.getFilePath();
        }
        StringBuffer fileContent = this.getFileContent();
        try {
            Files.writeString(fileName, fileContent, StandardOpenOption.APPEND);
            System.out.println("The content was appended successfully");
        } catch (IOException e) {
            this.displayWriteErrorMessage();
        }
    }

    private void displayWriteErrorMessage() {
        System.out.println("An error occurred while writing to the file");
        System.out.println("Please make sure you have enough disk space and access rights");
    }


    private enum FileOperation {
        READ, WRITE, APPEND
    }

}

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileScan {
    public static void main(String[] args) {
        System.out.println("Arguments length: " + args.length); // Debug print

        if (args.length > 0) {
            // Filename provided as command-line argument
            String fileName = args[0];
            System.out.println("File name from argument: " + fileName); // Debug print
            processFile(fileName);
        } else {
            // Launch JFileChooser to select file
            System.out.println("No command-line arguments provided, launching JFileChooser..."); // Debug print
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                processFile(selectedFile.getPath());
            }
        }
    }

    private static void processFile(String filePath) {
        System.out.println("Processing file: " + filePath); // Debug print
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            int charCount = 0;
            int wordCount = 0;
            int lineCount = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                lineCount++;
                charCount += line.length();
                wordCount += line.split("\\s+").length;
            }

            System.out.println("Characters: " + charCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Lines: " + lineCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

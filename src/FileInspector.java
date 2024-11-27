import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("src"));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            processFile(selectedFile);
        }
    }

    private static void processFile(File file) {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] words = line.split("\\s+");
                wordCount += words.length;
                charCount += line.length();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nSummary Report:");
        System.out.println("File name: " + file.getName());
        System.out.println("Number of lines: " + lineCount);
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of characters: " + charCount);
    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean continueInput = true;
        while (continueInput) {
            String firstName = SafeInput.getNonEmptyString(scanner, "Enter First Name: ");
            String lastName = SafeInput.getNonEmptyString(scanner, "Enter Last Name: ");
            String idNumber = SafeInput.getFormattedID(scanner, "Enter ID Number (6 digits): ");
            String email = SafeInput.getNonEmptyString(scanner, "Enter Email: ");
            int yearOfBirth = SafeInput.getInt(scanner, "Enter Year of Birth (4 digits): ", 1000, 9999);

            String record = String.format("%s,%s,%s,%s,%d", firstName, lastName, idNumber, email, yearOfBirth);
            records.add(record);

            System.out.print("Do you want to enter another record? (yes/no): ");
            continueInput = scanner.nextLine().equalsIgnoreCase("yes");
        }

        // Prompt for file name and write to file
        System.out.print("Enter the file name to save the records (with .csv extension): ");
        String fileName = scanner.nextLine();

        // Validate the file name and extension
        if (!fileName.endsWith(".csv")) {
            fileName += ".csv";
        }

        // Create the file in the src directory
        File file = new File("src", fileName);

        try (FileWriter writer = new FileWriter(file)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Records saved successfully to " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

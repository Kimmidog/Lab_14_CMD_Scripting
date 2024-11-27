import java.util.Scanner;

public class SafeInput {

    public static String getNonEmptyString(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    public static String getFormattedID(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (!input.matches("\\d{6}"));
        return input;
    }

    public static int getInt(Scanner scanner, String prompt, int min, int max) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    break;
                }
            }
            scanner.nextLine(); // clear invalid input
        }
        scanner.nextLine(); // consume newline
        return input;
    }
}

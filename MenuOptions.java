import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuOptions {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Welcome to the Menu System ===");
        int choice;

        do {
            displayMenu();
            choice = getValidInput();
            processChoice(choice);
        } while (choice != 4);

        scanner.close();
        System.out.println("\nThank you for using the Menu System!");
    }

    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(35));
        System.out.println("Please select an option:");
        System.out.println("=".repeat(35));
        System.out.println("1. Display System Information");
        System.out.println("2. Calculate Square of a Number");
        System.out.println("3. Display Current Timestamp");
        System.out.println("4. Exit");
        System.out.println("=".repeat(35));
        System.out.print("Enter your choice (1-4): ");
    }

    private static int getValidInput() {
        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number!");
                scanner.nextLine(); // Clear the invalid input
                System.out.print("Enter your choice (1-4): ");
            }
        }
        return choice;
    }

    private static void processChoice(int choice) {
        System.out.println();

        switch (choice) {
            case 1:
                displaySystemInfo();
                break;
            case 2:
                calculateSquare();
                break;
            case 3:
                displayTimestamp();
                break;
            case 4:
                System.out.println("Exiting program...");
                break;
            default:
                System.out.println("Invalid option! Please select a number between 1 and 4.");
        }
    }

    private static void displaySystemInfo() {
        System.out.println("--- System Information ---");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Operating System: " + System.getProperty("os.name"));
        System.out.println("User: " + System.getProperty("user.name"));
        System.out.println("Working Directory: " + System.getProperty("user.dir"));
    }

    private static void calculateSquare() {
        System.out.print("Enter a number to square: ");
        try {
            double number = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            double result = number * number;
            System.out.println("Result: " + number + " squared = " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number!");
            scanner.nextLine(); // Clear invalid input
        }
    }

    private static void displayTimestamp() {
        System.out.println("--- Current Timestamp ---");
        System.out.println("Date and Time: " + java.time.LocalDateTime.now());
        System.out.println("Unix Timestamp: " + System.currentTimeMillis() + " ms");
    }
}

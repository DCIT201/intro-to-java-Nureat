import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("What do you want to convert?");
        System.out.println("1. Celsius to Fahrenheit ");
        System.out.println("2. Fahrenheit to Celsius");

        int choice;
        // Validate the conversion choice (1 or 2)
        do {
            System.out.print("Enter your choice (1 or 2): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2); // Keep asking until a valid choice is entered

        if (choice == 1) {
            // Celsius to Fahrenheit conversion
            double celsius = Double.NaN;
            while (Double.isNaN(celsius)) {
                System.out.println("Please input the temperature in Celsius:");
                if (scanner.hasNextDouble()) {
                    celsius = scanner.nextDouble();
                    // Check for extreme temperature in Celsius (below absolute zero or above 1000°C)
                    if (celsius < -273.15) {
                        System.out.println("Temperature cannot be below absolute zero (-273.15°C). Please enter a valid temperature.");
                        celsius = Double.NaN; // Force the loop to continue
                    } else if (celsius > 1000) {
                        System.out.println("Temperature cannot exceed 1000°C. Please enter a valid temperature.");
                        celsius = Double.NaN; // Force the loop to continue
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number for Celsius.");
                    scanner.next(); // Clear invalid input
                }
            }

            // Perform the conversion if valid
            double fahrenheit = (celsius * 9 / 5) + 32;
            System.out.printf("%.2f°C is equal to %.2f°F%n", celsius, fahrenheit);
        }
        else if (choice == 2) {
            // Fahrenheit to Celsius conversion
            double fahrenheit = Double.NaN;
            while (Double.isNaN(fahrenheit)) {
                System.out.println("Please input the temperature in Fahrenheit:");
                if (scanner.hasNextDouble()) {
                    fahrenheit = scanner.nextDouble();
                    // Check for extreme temperature in Fahrenheit (below absolute zero or above 1832°F)
                    if (fahrenheit < -459.67) {
                        System.out.println("Temperature cannot be below absolute zero (-459.67°F). Please enter a valid temperature.");
                        fahrenheit = Double.NaN; // Force the loop to continue
                    } else if (fahrenheit > 1832) {
                        System.out.println("Temperature cannot exceed 1832°F. Please enter a valid temperature.");
                        fahrenheit = Double.NaN; // Force the loop to continue
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number for Fahrenheit.");
                    scanner.next(); // Clear invalid input
                }
            }

            // Perform the conversion if valid
            double celsius = (fahrenheit - 32) * 5 / 9;
            System.out.printf("%.2f°F is equal to %.2f°C%n", fahrenheit, celsius);
        }

        scanner.close();
    }
}
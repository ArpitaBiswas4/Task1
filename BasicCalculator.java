import java.util.Scanner;

public class BasicCalculator {

    // Method for addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method for division
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed!");
            return Double.NaN;
        }
        return a / b;
    }

    // Method to display menu
    public static void menu() {
        System.out.println("\n\n=== Java Basic Calculator ===");
        System.out.println("Press 1 for Addition (+)");
        System.out.println("Press 2 for Subtraction (-)");
        System.out.println("Press 3 for Multiplication (*)");
        System.out.println("Press 4 for Division (/)");
        System.out.println("Press 0 for Exit");
        System.out.print("\nChoose an operation (0-4): ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        double num1=0.0, num2=0.0, result;

        System.out.println("Welcome to Java Basic Calculator!");

        do {
            menu();

            try {
                ch = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 0-4.");
                sc.nextLine(); // Clear invalid input
                ch = -1; // Set to invalid value to continue loop
                continue;
            }

            // Get numbers from user
            if (ch >= 1 && ch <= 4) {
                System.out.print("Enter first number: ");
                try {
                    num1 = sc.nextDouble();
                } catch (Exception e) {
                    System.out.println("Invalid number format!");
                    sc.nextLine(); // Clear invalid input
                    continue;
                }

                System.out.print("Enter second number: ");
                try {
                    num2 = sc.nextDouble();
                } catch (Exception e) {
                    System.out.println("Invalid number format!");
                    sc.nextLine(); // Clear invalid input
                    continue;
                }
            }

            switch (ch) {
                case 1:
                    result = add(num1, num2);
                    System.out.printf("Result: %.2f + %.2f = %.2f\n", num1, num2, result);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    System.out.printf("Result: %.2f - %.2f = %.2f\n", num1, num2, result);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    System.out.printf("Result: %.2f * %.2f = %.2f\n", num1, num2, result);
                    break;
                case 4:
                    result = divide(num1, num2);
                    if (!Double.isNaN(result)) {
                        System.out.printf("Result: %.2f / %.2f = %.2f\n", num1, num2, result);
                    }
                    break;
                case 0:
                    System.out.println("Thank you for using the calculator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 0-4.");
            }

        } while (ch != 0);

        sc.close();
    }
}
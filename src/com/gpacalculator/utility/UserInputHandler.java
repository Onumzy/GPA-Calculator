package src.com.gpacalculator.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputHandler {
    public static int captureValidIntegerInput(Scanner scanner, String prompt, int minValue, int maxValue) {
        int userInput = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(prompt);
                userInput = scanner.nextInt();

                if (userInput >= minValue && userInput <= maxValue) {
                    isValidInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a valid integer between " + minValue + " and " + maxValue + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        return userInput;
    }

 

        public static String validateWithRegex(Scanner scanner, String prompt, String regex) {
        String input;

        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter a valid value.");
            }
        }
    }
}

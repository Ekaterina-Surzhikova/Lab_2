import java.util.Scanner;

public class Validator {
    public static int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите число.");
            }
        }
    }

    public static boolean isValidIndex(int index, int listSize) {
        return index >= 0 && index < listSize;
    }

    public static boolean isInRange(int number, int min, int max) {
        return number >= min && number <= max;
    }

    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static int getPositiveIntInput(Scanner scanner, String prompt) {
        while (true) {
            int number = getIntInput(scanner, prompt);
            if (number > 0) {
                return number;
            } else {
                System.out.println("Ошибка! Введите положительное число.");
            }
        }
    }

    public static int getIntInRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int number = getIntInput(scanner, prompt);
            if (number >= min && number <= max) {
                return number;
            } else {
                System.out.println("Ошибка! Введите число от " + min + " до " + max + ".");
            }
        }
    }
}
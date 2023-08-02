package bullscows;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length of the secret code:");
        System.out.print("> ");
        int length;
        try {
            length = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: \"" + e.getMessage().split(":")[1].trim() + "\" isn't a valid number.");
            return;
        }

        System.out.println("Input the number of possible symbols in the code:");
        System.out.print("> ");
        int numPossibleSymbols;
        try {
            numPossibleSymbols = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: \"" + e.getMessage().split(":")[1].trim() + "\" isn't a valid number.");
            return;
        }

        if (length <= 0 || numPossibleSymbols <= 0) {
            System.out.println("Error: Length and number of possible symbols should be positive numbers.");
            return;
        }

        String secretCode = generateSecretCode(length, numPossibleSymbols);
        if (secretCode == null) {
            return;
        }

        System.out.println("The secret is prepared: " + getHiddenCode(length) + " (" + getSecretCodeRange(numPossibleSymbols) + ").");
        System.out.println("Okay, let's start a game!");

        int turn = 1;
        while (true) {
            System.out.println("Turn " + turn + ":");
            String guess = scanner.nextLine();
            if (guess.length() != length) {
                System.out.println("Error: The guess should have a length of " + length + ".");
                return;
            }

            if (!guess.matches("[0-9a-z]+")) {
                System.out.println("Error: Your guess contains invalid symbols.");
                return;
            }

            int bulls = 0;
            int cows = 0;
            for (int i = 0; i < length; i++) {
                char digit = guess.charAt(i);
                if (digit == secretCode.charAt(i)) {
                    bulls++;
                } else if (secretCode.contains(String.valueOf(digit))) {
                    cows++;
                }
            }

            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s)");

            if (bulls == length) {
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }

            turn++;
        }

        scanner.close();
    }

    private static String generateSecretCode(int length, int numPossibleSymbols) {
        if (length > 36) {
            System.out.println("Error: Maximum secret code length is 36.");
            return null;
        }

        if (numPossibleSymbols > 36) {
            System.out.println("Error: Maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return null;
        }

        if (numPossibleSymbols < length) {
            System.out.println("Error: It's not possible to generate a code with a length of " + length + " with " + numPossibleSymbols + " unique symbols.");
            return null;
        }

        String possibleSymbols = "0123456789abcdefghijklmnopqrstuvwxyz".substring(0, numPossibleSymbols);
        Random random = new Random();
        Set<Character> uniqueSymbols = new HashSet<>();
        StringBuilder secretCodeBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char symbol = possibleSymbols.charAt(random.nextInt(numPossibleSymbols));
            if (!uniqueSymbols.contains(symbol)) {
                uniqueSymbols.add(symbol);
                secretCodeBuilder.append(symbol);
            } else {
                i--;
            }
        }

        return secretCodeBuilder.toString();
    }

    private static String getHiddenCode(int length) {
        return "*".repeat(length);
    }

    private static String getSecretCodeRange(int numPossibleSymbols) {
        String possibleSymbols = "0123456789abcdefghijklmnopqrstuvwxyz".substring(0, numPossibleSymbols);
        return "0-9, a-" + possibleSymbols.charAt(numPossibleSymbols - 1);
    }
}

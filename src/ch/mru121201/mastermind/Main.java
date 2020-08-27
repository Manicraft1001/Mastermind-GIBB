package ch.mru121201.mastermind;

import ch.mru121201.mastermind.objects.Color;
import ch.mru121201.mastermind.utils.AnsiColors;
import ch.mru121201.mastermind.utils.RandomColorCollector;
import ch.mru121201.mastermind.utils.RandomMessage;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static final int AMOUNT_SECRET_CODES = 4;

    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        Color.getColors().add(new Color('r', AnsiColors.ANSI_RED));
        Color.getColors().add(new Color('g', AnsiColors.ANSI_GREEN));
        Color.getColors().add(new Color('b', AnsiColors.ANSI_BLUE));
        Color.getColors().add(new Color('y', AnsiColors.ANSI_YELLOW));
        Color.getColors().add(new Color('w', AnsiColors.ANSI_WHITE));
        Color.getColors().add(new Color('c', AnsiColors.ANSI_CYAN));

        final List<Color> randomColors = RandomColorCollector.getColors(AMOUNT_SECRET_CODES);

        System.out.println(AnsiColors.ANSI_RED + "Successfully generated random code! (Solution: " + randomColors.toString() + ")");
        System.out.println(AnsiColors.ANSI_RED + "I bet, you can't find out my wholesome color code.");

        gameLoop(randomColors);
    }

    public void gameLoop(final List<Color> code) {
        final Scanner scanner = new Scanner(System.in);

        boolean finish = false;
        int tries = 0;
        int correct = 0;
        int incorrect = 0;

        while (!finish) {
            System.out.printf(AnsiColors.ANSI_RED + (RandomMessage.getEncourage()) + "%n", RandomColorCollector.displayUnknown(code));

            final String input = scanner.nextLine().replaceAll(" ", "");

            final StringBuilder stringBuilder = new StringBuilder();
            int correctGuess = 0;
            int correctColor = 0;

            for (int i = 0; i < code.size(); i++) {
                tries++;

                if (i > input.length()) {
                    incorrect++;
                    continue;
                }

                final Optional<Color> found = Color.getColorFromChar(input.charAt(i));
                if (!found.isPresent() || !code.contains(found.get())) {
                    stringBuilder.append("⚪");
                    incorrect++;
                    continue;
                }

                if (found.get().equals(code.get(i))) {
                    stringBuilder.append(code.get(i).getColorDot()).append(AnsiColors.ANSI_RESET);
                    correctGuess++;
                    correct++;
                } else {
                    stringBuilder.append("⚪");
                    correctColor++;
                    incorrect++;
                }
            }

            System.out.println(AnsiColors.ANSI_RED + "Your answer: " + stringBuilder.toString() + " " + AnsiColors.ANSI_RED + correctGuess + " correct colors and positions, " + correctColor + " correct colors");

            if (correctGuess == code.size()) {
                finish = true;
            }
        }

        System.out.println(AnsiColors.ANSI_GREEN + "Congrats, you finished the game! (" + tries + " tries)");
        System.out.println(AnsiColors.ANSI_GREEN + "Correct: " + correct + " Incorrect: " + incorrect);
        System.out.println(AnsiColors.ANSI_GREEN + "Game will quit now...");
    }
}
package ch.mru121201.mastermind;

import ch.mru121201.mastermind.objects.Color;
import ch.mru121201.mastermind.utils.RandomColorCollector;
import ch.mru121201.mastermind.utils.RandomMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static final int AMOUNT_SECRET_CODES = 4;

    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        Color.getColors().add(new Color('r', "\u001b[31m"));
        Color.getColors().add(new Color('g', "\u001b[32m"));
        Color.getColors().add(new Color('b', "\u001b[34m"));
        Color.getColors().add(new Color('y', "\u001b[33m"));
        Color.getColors().add(new Color('w', "\u001b[37m"));
        Color.getColors().add(new Color('s', "\u001b[30m"));

        final List<Color> randomColors = RandomColorCollector.getColors(AMOUNT_SECRET_CODES);

        System.out.println("Successfully generated random code! (Solution: " + randomColors.toString() + ")");
        System.out.println("I bet, you can't find out my wholesome color code.");

        gameLoop(randomColors);
    }

    public void gameLoop(final List<Color> code) {
        final Scanner scanner = new Scanner(System.in);

        boolean finised = false;
        int tries = 0;
        int correct = 0;
        int incorrect = 0;

        while (!finised) {
            System.out.println(String.format(RandomMessage.getEncourage(), RandomColorCollector.displayUnknown(code)));

            final String input = scanner.next();
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
                    stringBuilder.append("⬜");
                    incorrect++;
                    continue;
                }

                if (found.get().equals(code.get(i))) {
                    stringBuilder.append(code.get(i).getColorDot()).append(Color.ANSI_RESET);
                    correctGuess++;
                    correct++;
                } else {
                    stringBuilder.append("⬜");
                    correctColor++;
                    incorrect++;
                }
            }

            System.out.println("Your answer: " + stringBuilder.toString() + " " + correctGuess + " correct colors and positions, " + correctColor + " correct colors");

            if (correctGuess == code.size()) {
                finised = true;
            }
        }

        System.out.println("Congrats, you finished the game! (" + tries + " tries)");
        System.out.println("Correct: " + correct + " Incorrect: " + incorrect);
        System.out.println("Game will quit now...");
    }
}
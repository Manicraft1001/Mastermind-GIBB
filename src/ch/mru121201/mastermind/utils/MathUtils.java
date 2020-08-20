package ch.mru121201.mastermind.utils;

import java.util.Collections;
import java.util.Random;

public class MathUtils {

    /**
     * Method to get a random int between
     * a specific range defined by lower
     * and upper parameters. Avoid negative
     * values
     * @param lower the lower border
     * @param upper the upper border
     * @return returns a random int in the provided
     * range
     */
    public static int getRandom(final int lower, final int upper) {
        final Random random = new Random();
        return random.nextInt((upper - lower) + 1) + lower;
    }

    /**
     * Method to repeat a char-sequence
     * n times
     * @param charSequence the sequence to repeat
     * @param count the count to repeat
     * @return returns the repeated sequence
     */
    public static String repeatCharSequence(final CharSequence charSequence, final int count) {
        return String.join("", Collections.nCopies(count, charSequence));
    }
}

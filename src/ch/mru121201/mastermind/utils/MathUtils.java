package ch.mru121201.mastermind.utils;

import java.util.Random;

public class MathUtils {

    public static int getRandom(final int lower, final int upper) {
        final Random random = new Random();
        return random.nextInt((upper - lower) + 1) + lower;
    }
}

package ch.mru121201.mastermind.utils;

import ch.mru121201.mastermind.objects.Color;

import java.util.*;

public class RandomColorCollector {

    public static List<Color> getColors(final int amount) {
        final Set<Color> colors = new HashSet<>();
        while (colors.size() < amount)
            colors.add(Color.getColors().get(MathUtils.getRandom(0, Color.getColors().size() - 1)));
        return new ArrayList<>(colors);
    }

    /**
     * Method to display the colors
     * as unknown chars
     * @param colors the color collection
     * @return returns a string with colors replaced
     * by an unknown char
     */
    public static String displayUnknown(final List<Color> colors) {
        return AnsiColors.ANSI_BLACK + MathUtils.repeatCharSequence("⚫", colors.size());
    }
}

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

    public static String displayUnknown(final List<Color> colors) {
        return String.join("", Collections.nCopies(colors.size(), "⬜"));
    }
}

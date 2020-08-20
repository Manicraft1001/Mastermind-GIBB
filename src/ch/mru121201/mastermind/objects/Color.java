package ch.mru121201.mastermind.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Color {

    private static List<Color> colors;

    public static List<Color> getColors() {
        if (colors == null)
            colors = new ArrayList<>();
        return colors;
    }

    private final char color;
    private final String ansi_code;

    public Color(final char color, final String ansi_code) {
        this.color = color;
        this.ansi_code = ansi_code;
    }

    public char getColorFromChar() {
        return color;
    }

    public String getAnsi_code() {
        return ansi_code;
    }

    public String getColorDot() {
        return getAnsi_code() + "⚪";
    }

    @Override
    public String toString() {
        return "Color{" +
                "v=" + color +
                '}';
    }

    public static final String ANSI_RESET = "\u001B[0m";

    public static Optional<Color> getColorFromChar(final char color) {
        return colors.stream().filter(color1 -> color1.color == color).findFirst();
    }
}

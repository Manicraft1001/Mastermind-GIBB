package ch.mru121201.mastermind.utils;

import java.util.Arrays;
import java.util.List;

public class RandomMessage {

    private final static List<String> encourageMessages = Arrays.asList(
            "I bet you can't find out my code: %s",
            "Are you still trying? %s",
            "You can breathe. But can you solve this? %s",
            "Even the NASA failed at my puzzle: %s",
            "Maybe you should stop? %s",
            "Take a break, drink coffee and resume: %s");

    public static String getEncourage() {
        return encourageMessages.get(MathUtils.getRandom(0, encourageMessages.size() - 1));
    }
}

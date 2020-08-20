package ch.mru121201.mastermind.utils;

import java.util.Arrays;
import java.util.List;

public class RandomMessage {

    private final static List<String> encourageMessages = Arrays.asList(
            "I bet you can't find out my code: %s",
            "Are you still trying? %s",
            "You can breathe. But can you solve this? %s",
            "Even the NASA failed at my puzzle: %s",
            "Are you okay, sir? %s",
            "Isn't it boring? %s",
            "Better overthink your idea. %s",
            "Maybe you should stop? %s",
            "Take a break, sip your coffee and slove this: %s");

    /**
     * Method to get a random encourage sentence
     * @return returns a random encourage as a string
     */
    public static String getEncourage() {
        return encourageMessages.get(MathUtils.getRandom(0, encourageMessages.size() - 1));
    }
}
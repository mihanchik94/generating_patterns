package task_2;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NumberFiller {
    private static final Random random = new Random();

    public static List<Integer> fillRandom(int amount, int maxValue) {
        return random.ints(amount, 0, maxValue)
                .boxed().collect(Collectors.toList());
    }
}
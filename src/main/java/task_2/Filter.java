package task_2;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private final int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (Integer num : source) {
            if (num < treshold) {
                logger.log("Элемент \"" + num +"\" не проходит");
            }   else {
                logger.log("Элемент \"" + num +"\" проходит");
                result.add(num);
            }
        }
        logger.log(String.format("Прошло фильтр %d элемента из %d", result.size(), source.size()));
        return result;
    }
}
package task_2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        try (Scanner scanner = new Scanner(System.in)) {
            logger.log("Запускаем программу");
            logger.log("Просим пользователя ввести входные данные для списка");

            System.out.println("Введите размер списка:");
            int size = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите верхнюю границу для значений:");
            int maxValue = Integer.parseInt(scanner.nextLine());

            logger.log("Создаём и наполняем список");
            List<Integer> numbers = NumberFiller.fillRandom(size, maxValue);
            System.out.println("Первоначальный список: " + numbers.toString());

            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.println("Введите порог для фильтра:");
            int treshold = Integer.parseInt(scanner.nextLine());

            logger.log("Запускаем фильтрацию");
            Filter filter = new Filter(treshold);
            List<Integer> filteredNumbers = filter.filterOut(numbers);

            logger.log("Выводим результат на экран");
            System.out.println("Отфильтрованный список: " + filteredNumbers.toString());

            logger.log("Завершаем программу");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
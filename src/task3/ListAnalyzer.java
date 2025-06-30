package task3;

import java.util.*;
import java.util.stream.Collectors;

public class ListAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> list1 = readList(scanner, "первого");
        if (list1 != null) {
            analyzeList(list1, "первого");
        }

        List<Double> list2 = readList(scanner, "второго");
        if (list2 != null) {
            analyzeList(list2, "второго");
        }

        if (list1 != null && list2 != null) {
            combineLists(list1, list2);
        }

        scanner.close();
    }

    private static List<Double> readList(Scanner scanner, String listName) {
        while (true) {
            System.out.printf("\nВведите числа для %s списка через пробел:\n", listName);
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Ошибка: список не может быть пустым. Попробуйте еще раз.");
                continue;
            }

            try {
                return Arrays.stream(input.trim().split("\\s+"))
                        .map(s -> s.replace(',', '.'))
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не число. Пожалуйста, проверьте данные и попробуйте еще раз.");
            }
        }
    }

    private static void analyzeList(List<Double> list, String listName) {
        System.out.printf("\n--- Анализ %s списка ---\n", listName);

        Optional<Double> max = list.stream().max(Double::compare);
        max.ifPresent(aDouble -> System.out.println("Максимальное число: " + aDouble));

        OptionalDouble average = list.stream().mapToDouble(d -> d).average();
        average.ifPresent(aDouble -> System.out.println("Среднее арифметическое: " + aDouble));

        List<Double> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println("Отсортированный список: " + listToString(sortedList));

        List<Double> uniqueElements = list.stream().distinct().collect(Collectors.toList());
        System.out.println("Уникальные элементы: " + listToString(uniqueElements));
    }

    private static void combineLists(List<Double> list1, List<Double> list2) {
        Set<Double> combinedSet = new HashSet<>(list1);
        combinedSet.addAll(list2);
        List<Double> combinedList = new ArrayList<>(combinedSet);
        Collections.sort(combinedList);
        System.out.println("\nОбъединенный отсортированный список без дубликатов: " + listToString(combinedList));
    }

    private static String listToString(List<Double> list) {
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}

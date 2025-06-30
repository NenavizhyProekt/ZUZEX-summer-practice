package task2;

import java.util.Scanner;

public class NumberAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВведите число для анализа или 'exit' для выхода:");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Программа завершена.");
                break;
            }

            try {
                double number = Double.parseDouble(input.replace(',', '.'));
                analyzeNumber(number);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введено не число. Пожалуйста, попробуйте еще раз.");
            }
        }
        scanner.close();
    }

    public static void analyzeNumber(double number) {
        System.out.println("Анализ числа: " + number);

        if (number > 0) {
            System.out.println("- Положительное");
        } else if (number < 0) {
            System.out.println("- Отрицательное");
        } else {
            System.out.println("- Ноль");
        }

        boolean isFractional = (number % 1 != 0);
        if (isFractional) {
            System.out.println("- Дробное");
        } else {
            System.out.println("- Целое (не дробное)");
        }

        if (!isFractional) {
            if (number % 2 == 0) {
                System.out.println("- Четное");
            } else {
                System.out.println("- Нечетное");
            }
        }

        if (!isFractional && number > 1) {
            if (isPrime((long) number)) {
                System.out.println("- Простое");
            } else {
                System.out.println("- Составное");
            }
        }

        System.out.println("- Квадрат: " + (number * number));

        if (number < 0) {
            System.out.println("- Квадратный корень: Невозможно извлечь из отрицательного числа");
        } else {
            System.out.println("- Квадратный корень: " + Math.sqrt(number));
        }
    }

    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
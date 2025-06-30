package task3;

import java.util.Scanner;

public class StringAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВведите строку для анализа или 'exit' для выхода:");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Программа завершена.");
                break;
            }

            analyzeString(input);
        }
        scanner.close();
    }

    public static void analyzeString(String str) {
        if (str == null) {
            System.out.println("Ошибка: введена пустая строка (null).");
            return;
        }

        String[] words = str.trim().isEmpty() ? new String[0] : str.trim().split("\\s+");
        int wordCount = words.length;

        int letterCount = 0;
        int vowelCount = 0;
        int consonantCount = 0;
        int punctuationCount = 0;
        int spaceCount = 0;

        String vowels = "аеёиоуыэюяaeiouy";
        String punctuation = ".,!?;:-()\"'«»";

        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                letterCount++;
                if (vowels.indexOf(Character.toLowerCase(ch)) != -1) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            } else if (Character.isWhitespace(ch)) {
                spaceCount++;
            } else if (punctuation.indexOf(ch) != -1) {
                punctuationCount++;
            }
        }

        System.out.println("Анализ строки: \"" + str + "\"");
        System.out.println("Кол-во слов: " + wordCount);
        System.out.println("Кол-во букв: " + letterCount);
        System.out.println("Кол-во гласных: " + vowelCount);
        System.out.println("Кол-во согласных: " + consonantCount);
        System.out.println("Кол-во знаков препинания: " + punctuationCount);
        System.out.println("Кол-во пробелов: " + spaceCount);
    }
}

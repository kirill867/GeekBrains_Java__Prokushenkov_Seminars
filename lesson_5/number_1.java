package lesson_5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class number_1{
    public static void main(String[] args) {
        /*
         * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
         * человек может иметь несколько телефонов.
         * Добавить функции 1) Добавление номера
         * 2) Вывод всего
         * Пример:
         * Я ввожу: 1
         * К: Введите фамилию
         * Я: Иванов
         * К: Введите номер
         * Я: 1242353
         * К: Введите 1) Добавление номера
         * 2) Вывод всего
         * Я ввожу: 1
         * К: Введите фамилию
         * Я: Иванов
         * К: Введите номер
         * Я: 547568
         * К: Введите 1) Добавление номера
         * 2) Вывод всего
         * Я: 2
         * Иванов: 1242353, 547568
         */

        HashMap<String, ArrayList<Integer>> book = new HashMap<>();
        Scanner scan = new Scanner(System.in, "Cp866");
        while (true) {
            System.out.println(" 1 - добавить номер;  2 - вывода записей; 0 - выход. ");
            int item = scan.nextInt();
            scan.nextLine();
            if (item == 1) {
                addnumber(book, scan);
            }
            if (item == 2) {
                printall(book);
            }
            if (item == 0) {//!= 1 || item != 2 не работает! выполняется только 1 раз
            break;
            }
        }
        scan.close();
    }

    public static void addnumber(HashMap<String, ArrayList<Integer>> book, Scanner scanner) {
        System.out.println("Введите фамилию: ");
        String name = scanner.nextLine();
        System.out.println("Введите номер: ");
        int num = scanner.nextInt();
        if (!book.containsKey(name)) {
            book.put(name, new ArrayList<>());
        }
        book.get(name).add(num);
    }

    public static void printall(HashMap<String, ArrayList<Integer>> book) {
        if (book.isEmpty()){
            System.out.println("Список контактов пуст. ");
        }
        book.entrySet().forEach(entry -> {
            System.out.println(
                    entry.getKey() + ":" + entry.getValue().toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        });

    }
}
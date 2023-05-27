package lesson_5;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.SortedMap;

public class number_2{
    private static Object Key;
    private static Object Value;

    public static void main(String[] args) {
        /*
         * Пусть дан список сотрудников:
         * Иван Иванов
         * Светлана Петрова
         * Кристина Белова
         * Анна Мусина
         * Анна Крутова
         * Иван Юрин
         * Петр Лыков
         * Павел Чернов
         * Петр Чернышов
         * Мария Федорова
         * Марина Светлова
         * Мария Савина
         * Мария Рыкова
         * Марина Лугова
         * Анна Владимирова
         * Иван Мечников
         * Петр Петин
         * Иван Ежов
         * 
         * Написать программу, которая найдет и выведет повторяющиеся имена с
         * количеством повторений.
         * Отсортировать по убыванию популярности Имени.
         */
        // Входные данные
        ArrayList<String> humans = new ArrayList<>(
                Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                        "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                        "Марина Светлова",
                        "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                        "Петр Петин", "Иван Ежов"));
        // Создаем список для имен, вырезая их из списка сотрудников
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < humans.size(); i++) {
            names.add(humans.get(i).split(" ")[0]);
        }
        // Создаем МАР Key-имя, Value- счетчик и считаем встречающиеся в списке names
        // имена
        HashMap<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            if (!counter.containsKey(names.get(i))) {
                counter.put(names.get(i), 1);
            } else
                counter.put(names.get(i), counter.get(names.get(i)) + 1);
}
    
     

        
        System.out.println(counter);// печать всего МАРа без сортировки
        counter.entrySet().removeIf(entries->entries.getValue()==1);
        System.out.println(counter);// печать только повторяющихся имен из МАРа без сортировки
        // МАР в стрим, сортируем в обратном порядке и печатаем каждый
        // элемент
        counter.entrySet().stream()
                .sorted(Collections.reverseOrder(HashMap.Entry.comparingByValue()))
                .forEach(System.out::println);




    }
}
package Lesson3;

import java.util.*;

/**
 * Java. Level 2. Lesson 3. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 20.02.2019
 */

public class Lesson3Launcher {



    public static void main(String[] args) {

        // Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Стекло");
        stringArrayList.add("Шенель");
        stringArrayList.add("Нос");
        stringArrayList.add("Мост");
        stringArrayList.add("Кран");
        stringArrayList.add("Молоток");
        stringArrayList.add("Серп");
        stringArrayList.add("Дорога");
        stringArrayList.add("Кран");
        stringArrayList.add("Мост");
        stringArrayList.add("Стакан");
        stringArrayList.add("Стекло");
        stringArrayList.add("Java");
        stringArrayList.add("Код");
        stringArrayList.add("Java");
        stringArrayList.add("Массив");
        stringArrayList.add("Массив");
        stringArrayList.add("Мост");
        stringArrayList.add("Дорога");
        System.out.println(stringArrayList);


        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        // Посчитать сколько раз встречается каждое слово.
        Map<String, Integer> stringHashMap = new HashMap<>();
        for (String s: stringArrayList) {
            Integer frequency = stringHashMap.get(s);
            stringHashMap.put(s, frequency == null ? 1 : frequency + 1);
        }
        System.out.println(stringHashMap);



    }



}

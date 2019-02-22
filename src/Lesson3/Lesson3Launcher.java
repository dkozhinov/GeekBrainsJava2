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

        // 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
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
        System.out.println("Выполнен подсчет, сколько раз встречается каждое слово:");
        System.out.println(stringHashMap);



        // 2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
        // телефонных номеров. В этот телефонный справочник с помощью метода add() можно
        // добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
        // учесть, что под одной фамилией может быть несколько телефонов (в случае
        // однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "123-456-78");
        phoneBook.add("Иванов", "123-456-00");
        phoneBook.add("Петров", "223-456-78");
        phoneBook.add("Сидоров", "323-456-78");
        phoneBook.add("Иванов", "223-000-01");

        System.out.println("\nПеребор всех элементов списка:");
        phoneBook.getAll();

        System.out.println("\nПоиск в телефонном справочнике по фамилии:");
        String fio = "Иванов";
        phoneBook.get(fio);
        fio = "Петров";
        phoneBook.get(fio);

    }



}

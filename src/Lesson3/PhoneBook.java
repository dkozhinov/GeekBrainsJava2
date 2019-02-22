package Lesson3;


import java.util.*;

/**
 * Java. Level 2. Lesson 3. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 20.02.2019
 */


// 2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
// телефонных номеров. В этот телефонный справочник с помощью метода add() можно
// добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
// учесть, что под одной фамилией может быть несколько телефонов (в случае
// однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
public class PhoneBook {

    private Set<String> phoneNumberHashSet;
    private Map<String, Set<String>> phoneBookHashMap;

    public PhoneBook() {
        this.phoneBookHashMap = new HashMap<>();
    }

    public void add(String fio, String phoneNumber) {
        if (phoneBookHashMap.containsKey(fio)) {
            phoneNumberHashSet = phoneBookHashMap.get(fio);
        }
        else {
            phoneNumberHashSet = new HashSet<>();
        }
        phoneNumberHashSet.add(phoneNumber);
        phoneBookHashMap.put(fio,phoneNumberHashSet);
    }

    public void get(String fio) {
        if (phoneBookHashMap.containsKey(fio)) {
            phoneNumberHashSet = phoneBookHashMap.get(fio);
            System.out.println(fio + ":" + phoneNumberHashSet);
        }
        else {
            System.out.println(fio + " отсутствует в телефонном справочнике!");
        }

    }

    // перебор всех элементов списка
    public void getAll() {
        // перебор элементов Entry отображения с помощью for
        for (String key : phoneBookHashMap.keySet()) {
            phoneNumberHashSet = phoneBookHashMap.get(key);
            System.out.println(key + ":" + phoneNumberHashSet);
        }

    }

}

package Lesson3;


import java.util.ArrayList;
import java.util.List;

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

    private List<String> fioArrayList;
    private List<String> phoneNumberArrayList;

    public PhoneBook() {
        this.fioArrayList = new ArrayList<>();
        this.phoneNumberArrayList = new ArrayList<>();
    }

    public void add(String fio, String phoneNumber) {
        int index = fioArrayList.size();
        if (index != phoneNumberArrayList.size()) {
            System.out.println("Телефонный справочник поврежден!");
            return;
        }
        fioArrayList.add(index, fio);
        phoneNumberArrayList.add(index, phoneNumber);
    }

    public void get(String fio) {
        for (int i = 0; i < fioArrayList.size(); i++)
        {
            if ( fioArrayList.get(i) == fio) {
                System.out.println(fio + ":" + phoneNumberArrayList.get(i));
            }
        }
    }

    // перебор всех элементов списка
    public void getAll() {
        for (int i = 0; i < fioArrayList.size(); i++)
        {
            System.out.println(fioArrayList.get(i) + ":" + phoneNumberArrayList.get(i));
        }
    }

}

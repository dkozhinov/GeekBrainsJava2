package Lesson1;

import java.util.ArrayList;
import java.util.List;

/**
 * Java. Level 2. Lesson 1. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 14.02.2019
 */


// Класс Team содержит: название команды, массив из 4-х участников
// (т.е. в конструкторе можно сразу всех участников указывать),
// метод для вывода информации о членах команды прошедших дистанцию,
// метод вывода информации обо всех членах команды.
public class Team {

    List<Animal> members = new ArrayList<>();

    public Team(List<Animal> members) {
        this.members = members;
    }

    public List<Animal> getMembers() {
        return members;
    }

    public void GetTeamSuccessfulResultInfo() {
        int counter=0;
        System.out.println("Информация о членах команды прошедших дистанцию:");

        for (Animal animal : members)
        {
            if (animal.getResult()) {
                counter++;
                System.out.println(" " + animal.toString());
            }
        }

        if (counter==0) {
            System.out.println(" никто не прошел дистанцию.");
        }

    }


    public void GetTeamInfo() {
        System.out.println("Информация обо всех членах команды:");

        for (Animal animal : members)
        {
            System.out.println(" " + animal.toString());
        }

    }

}

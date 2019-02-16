package Lesson1;

import java.util.ArrayList;
import java.util.List;

/**
 * Java. Level 2. Lesson 1. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 14.02.2019
 */

public class TournamentLauncher {

    public static void main(String[] args) {

        List<Animal> members = new ArrayList<>();

        Animal member1 = new Cat(5, "BARSIK", TypeCat.BRITISH);
        Animal member2 = new Cat(10, "TOM", TypeCat.CHESHIRE);
        Animal member3 = new Dog(3, "MUHTAR", TypeDog.GERMANSHEPHERD);
        Animal member4 = new Human(44, "Dmitry Kozhinov", GenderHuman.MALE);

        members.add(member1);
        members.add(member2);
        members.add(member3);
        members.add(member4);

        // Инициализация массивов испытаний с ссответствующей дистанцией в метрах
        TypeCurse[] coursesName = {TypeCurse.JUMPING, TypeCurse.RUNNING, TypeCurse.SWIMING};
        //double[] coursesDistanseInMeters = {0.9, 20.0, 0};
        double[] coursesDistanseInMeters = {0.9, 200.0, 3};


        Team team = new Team(members);
        Course course = new Course(coursesName, coursesDistanseInMeters, members);

        team.GetTeamInfo();
        course.doIt();
        team.GetTeamSuccessfulResultInfo();

    }
}

package Lesson1;

import java.util.ArrayList;
import java.util.List;

/**
 * Java. Level 2. Lesson 1. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 14.02.2019
 */

public class Course{

    TypeCurse[] courses;
    double[] coursesDistanseInMeters;
    List<Animal> members = new ArrayList<>();

    public Course(TypeCurse[] courses, double[] coursesDistanseInMeters, List<Animal> members) {
        this.courses = courses;
        this.coursesDistanseInMeters = coursesDistanseInMeters;
        this.members = members;
    }


    public void doIt() {

        if (coursesDistanseInMeters.length != courses.length) {
            return;
        }

        for (Animal animal : members)
        {
            int counter = 0;    // Счетчик пройденых участником испытаний
            for (int i=0; i < courses.length; i++) {
                if (courses[i] == TypeCurse.JUMPING && animal.jump(coursesDistanseInMeters[i])) {
                    counter++;
                }
                else if (courses[i] == TypeCurse.RUNNING && animal.run(coursesDistanseInMeters[i])) {
                    counter++;
                }
                else if (courses[i] == TypeCurse.SWIMING && animal.swim(coursesDistanseInMeters[i])) {
                    counter++;
                };
            }
            // Если счетчик испытаний будет равен количеству испытаний, то участник успешно прошел испытания
            if (counter == courses.length) {
                animal.setResult(true);
            }
            else {
                animal.setResult(false);
            }
        }

    }

}

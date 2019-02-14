package Lesson1;

/**
 * Java. Level 2. Lesson 1. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 14.02.2019
 */

public abstract class Animal implements Jumping, Runing, Swiming
{
    private int age;
    private String name;


    public Animal(int age, String name)
    {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Animal{" + "age=" + age + ", name='" + name + '\'' + '}';
    }

    public int getAge()
    {
        return age;
    }
    public String getName()
    {
        return name;
    }
    public abstract String getType();
}


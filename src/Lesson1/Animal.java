package Lesson1;

/**
 * Java. Level 2. Lesson 1. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 14.02.2019
 */

public abstract class Animal implements Jumping, Running, Swiming
{
    private int age;
    private String name;
    private boolean result;


    public Animal(int age, String name)
    {
        this.age = age;
        this.name = name;
        this.result = false;
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
    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}


package Lesson1;

/**
 * Java. Level 2. Lesson 1. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 14.02.2019
 */

public class Cat extends Animal
{
    private TypeCat type;
    private final static double DEFAULT_JUMP_VALUE = 1.0;
    private final static double DEFAULT_RUN_VALUE = 200.0;
    private final static double DEFAULT_SWIM_VALUE = 0.0;

    public Cat(int age, String name, TypeCat type)
    {
        super(age, name);
        this.type = type;
    }

    @Override
    public boolean jump(double distanceInMeters)
    {
        return  distanceInMeters <= DEFAULT_JUMP_VALUE * type.getRateOfJump();
    }

    @Override
    public boolean run(double distanceInMeters)
    {
        return  distanceInMeters <= DEFAULT_RUN_VALUE * type.getRateOfRun();
    }

    @Override
    public boolean swim(double distanceInMeters)
    {
        return  distanceInMeters <= DEFAULT_SWIM_VALUE * type.getRateOfSwim();
    }

    @Override
    public String toString()
    {
        return "Cat{" + "type='" + type + '\'' + "} " + super.toString();
    }
}

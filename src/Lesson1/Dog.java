package Lesson1;

/**
 * Java. Level 2. Lesson 1. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 14.02.2019
 */

public class Dog extends Animal{
    private TypeDog type;
    private final static double DEFAULT_JUMP_VALUE = 1.5;
    private final static double DEFAULT_RUN_VALUE = 2000.0;
    private final static double DEFAULT_SWIM_VALUE = 200.0;

    public Dog(int age, String name, TypeDog type)
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
        return "Dog{" + "type='" + type + '\'' + "} " + super.toString();
    }

}

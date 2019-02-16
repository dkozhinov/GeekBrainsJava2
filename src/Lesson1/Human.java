package Lesson1;

/**
 * Java. Level 2. Lesson 1. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 14.02.2019
 */

public class Human extends Animal {
    private GenderHuman type;
    private final static double DEFAULT_JUMP_VALUE = 1.5;
    private final static double DEFAULT_RUN_VALUE = 2000.0;
    private final static double DEFAULT_SWIM_VALUE = 300.0;

    public Human(int age, String name, GenderHuman type)
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
        return  getType() + " is " + super.toString();
    }

    @Override
    public String getType() {
        return "Human{" + "type='" + type.getNameOfType() + '\'' + "}";
    }

}

package Lesson1;

/**
 * Java. Level 2. Lesson 1. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 14.02.2019
 */

public enum GenderHuman {
    MALE(1,1, 0.8), FEMALE(0.8, 0.6,0.7);

    private double rateOfJump;
    private double rateOfRun;
    private double rateOfSwim;


    GenderHuman(double rateOfJump, double rateOfRun, double rateOfSwim)
    {
        this.rateOfJump = rateOfJump;
        this.rateOfRun = rateOfRun;
        this.rateOfSwim = rateOfSwim;
    }

    public double getRateOfJump()
    {
        return rateOfJump;
    }
    public double getRateOfRun()  {
        return rateOfRun;
    }
    public double getRateOfSwim() {
        return rateOfSwim;
    }

}

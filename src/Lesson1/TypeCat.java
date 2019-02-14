package Lesson1;

/**
 * Java. Level 2. Lesson 1. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 14.02.2019
 */

public enum TypeCat {
    PERSIAN(0.7,0.6, 0), BRITISH(0.6, 0.5,0),
    CHESHIRE(0.9, 0.8,0);

    private double rateOfJump;
    private double rateOfRun;
    private double rateOfSwim;


    TypeCat(double rateOfJump, double rateOfRun, double rateOfSwim)
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

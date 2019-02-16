package Lesson1;

/**
 * Java. Level 2. Lesson 1. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 14.02.2019
 */

public enum TypeDog {
    BULDOG("Buldog",0.4,1.2, 0.5), GERMANSHEPHERD("GermanShepherd",0.8, 1.8,0.6),
    LABRADOR("Labrador", 0.5, 1.0,0.7);

    private String nameOfType;
    private double rateOfJump;
    private double rateOfRun;
    private double rateOfSwim;


    TypeDog(String nameOfType, double rateOfJump, double rateOfRun, double rateOfSwim)
    {
        this.nameOfType = nameOfType;
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
    public String getNameOfType() {
        return nameOfType;
    }
}

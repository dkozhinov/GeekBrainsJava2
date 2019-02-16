package Lesson1;

/**
 * Java. Level 2. Lesson 1. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 14.02.2019
 */

public enum GenderHuman {
    MALE("Male",1,1, 0.8), FEMALE("Female",0.8, 0.6,0.7);

    private String nameOfType;
    private double rateOfJump;
    private double rateOfRun;
    private double rateOfSwim;


    GenderHuman(String nameOfType, double rateOfJump, double rateOfRun, double rateOfSwim)
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

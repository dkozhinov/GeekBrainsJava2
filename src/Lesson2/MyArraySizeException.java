package Lesson2;

/**
 * Java. Level 2. Lesson 2. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 17.02.2019
 */

public class MyArraySizeException extends RuntimeException {

    private int i;
    private int j;

    public MyArraySizeException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public String printException() {

        return "Получено исключение MyArraySizeException.\nРазмерность массива отличается от заданного размера " + i + "х" + j + " !";
    }

}

package Lesson2;

/**
 * Java. Level 2. Lesson 2. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 17.02.2019
 */

public class TestException {

    public static void main(String[] args) {
        //String[][] array = { {"11","12","13","14"}, {"21","22","23","24"}, {"31","32","33","34"}, {"41","42","43","44"} };
        //String[][] array = { {"11","12","13","14"}, {"99", "21","22","23","24"}, {"31","32","33","34"}, {"41","42","43","44"} };
        String[][] array = { {"11","12","13","14"}, {"21","q22","23","24"}, {"31","32","33","34"}, {"41","42","43","44"} };

        try {
            MyArray myArray = new MyArray(array);
            myArray.printArray();
            System.out.println("Сумма элементов массива=" + myArray.sumArray());
        }
        catch (MyArraySizeException e) {
            System.out.println(e.printException());
        }
        catch (MyArrayDataException e) {
            System.out.println(e.printException());
        }
        System.out.println("Программа завершена.");


    }
}

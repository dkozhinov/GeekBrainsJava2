package Lesson5;

import Lesson2.MyArray;

/**
 * Java. Level 2. Lesson 5. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 27.02.2019
 */

public class Lesson5Launcher {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        // Метод просто "бежит" по массиву и вычисляет значения
        myThread.makeArray();

        // Метод разбивает массив на два массива, в двух потоках высчитывает новые значения и
        // потом склеивает эти массивы обратно в один
        myThread.makeArrayWithThread();

        // Метод разбивает массив на четыре массива, в двух потоках высчитывает новые значения и
        // потом склеивает эти массивы обратно в один
        myThread.makeArrayWithThread4();

    }

}

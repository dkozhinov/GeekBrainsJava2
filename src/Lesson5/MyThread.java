package Lesson5;

import java.util.HashSet;

/**
 * Java. Level 2. Lesson 5. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 27.02.2019
 */

public class MyThread {

    private static final int SIZE = 10000000;
    private static final int HALF = SIZE/2;
    private static final int QUARTER = SIZE/4;

    private float[] array = new float[SIZE];
    private float[] array1 = new float[HALF];
    private float[] array2 = new float[HALF];
    private float[] array3 = new float[QUARTER];
    private float[] array4 = new float[QUARTER];


    public MyThread() {
        // Заполняем исходный массив единицами
        initializationInitialArray();
    }


    // Метод "бежит" по массиву и вычисляет значения
    public void makeArray() {
        long startTime = System.currentTimeMillis();    // Засекаем время начала и выполняем вычисления
        calculateInArray(SIZE, array);                    // Выполнение вычислений в массиве
        System.out.println("MakeArray: время выполнения=" + (System.currentTimeMillis() - startTime) + " милисекунд.");
    }



    // Метод разбивает массив на два массива, в двух потоках высчитывает новые значения и
    // потом склеивает эти массивы обратно в один
    public void makeArrayWithThread() {
        long startTime = System.currentTimeMillis();    // Засекаем время начала и выполняем вычисления

        // Разбиваем массив на два отдельных массива
        System.arraycopy(array,0,array1,0,HALF);
        System.arraycopy(array,HALF,array2,0,HALF);

        // Вычисляем в отдельных потоках
        Thread t1 = new InternalThread(HALF, array1);
        Thread t2 = new InternalThread(HALF, array2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch ( InterruptedException e) {
            e.printStackTrace();
        }

        // Собираем значения из двух массивов обратно в исходный массив
        System.arraycopy(array1,0,array,0,HALF);
        System.arraycopy(array2,0,array,HALF,HALF);

        System.out.println("makeArrayWithThread: время выполнения=" + (System.currentTimeMillis() - startTime) + " милисекунд.");
    }


    // Метод разбивает массив на четыре массива, в двух потоках высчитывает новые значения и
    // потом склеивает эти массивы обратно в один
    public void makeArrayWithThread4() {
        long startTime = System.currentTimeMillis();    // Засекаем время начала и выполняем вычисления

        // Разбиваем массив на четыре отдельных массива
        System.arraycopy(array,0,array1,0,QUARTER);
        System.arraycopy(array,QUARTER,array2,0,QUARTER);
        System.arraycopy(array,HALF,array3,0,QUARTER);
        System.arraycopy(array,HALF+QUARTER,array4,0,QUARTER);

        // Вычисляем в отдельных потоках
        Thread t1 = new InternalThread(QUARTER, array1);
        Thread t2 = new InternalThread(QUARTER, array2);
        Thread t3 = new InternalThread(QUARTER, array3);
        Thread t4 = new InternalThread(QUARTER, array4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch ( InterruptedException e) {
            e.printStackTrace();
        }

        // Собираем значения из четырех массивов обратно в исходный массив
        System.arraycopy(array1,0,array,0,QUARTER);
        System.arraycopy(array2,0,array,QUARTER,QUARTER);
        System.arraycopy(array3,0,array,HALF,QUARTER);
        System.arraycopy(array4,0,array,HALF+QUARTER,QUARTER);

        System.out.println("makeArrayWithThread4: время выполнения=" + (System.currentTimeMillis() - startTime) + " милисекунд.");
    }



    // Заполняем массив единицами
    private void initializationInitialArray() {
    }



    // Выполнение вычислений в массиве
    private void calculateInArray(int size, float[] array) {
        for (int i = 0; i < size; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }


    // Внутреннй класс для создания потоков для вычисления в массиве
    class InternalThread extends Thread {
        private int size;
        private float[] array;

        public InternalThread(int size, float[] array) {
            this.size = size;
            this.array = array;
        }

        @Override
        public void run() {
            calculateInArray(this.size, this.array);
        }


    }

}

package Lesson5;

import java.util.HashSet;

/**
 * Java. Level 2. Lesson 5. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 27.02.2019
 */

public class MyThread {

    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;
    static final int QUARTER = SIZE/4;

    // Метод "бежит" по массиву и вычисляет значения
    public void makeArray() {
        float[] array = new float[SIZE];

        // Заполняем массив единицами
        for(int i=0; i < SIZE; i++) { array[i]=1; }

        // Засекаем время начала и выполняем вычисления
        long startTime = System.currentTimeMillis();
        for(int i=0; i < SIZE; i++) { array[i] = calculate(array[i],i); }
        System.out.println("MakeArray: время выполнения=" + (System.currentTimeMillis() - startTime) + " милисекунд.");

    }

    // Метод разбивает массив на два массива, в двух потоках высчитывает новые значения и
    // потом склеивает эти массивы обратно в один
    public void makeArrayWithThread() {
        float[] array = new float[SIZE];
        float[] array1 = new float[HALF];
        float[] array2 = new float[HALF];

        // Заполняем массив единицами
        for(int i=0; i < SIZE; i++) { array[i]=1; }

        // Засекаем время начала и выполняем вычисления
        long startTime = System.currentTimeMillis();
        // Разбиваем массив на два отдельных массива
        System.arraycopy(array,0,array1,0,HALF);
        System.arraycopy(array,HALF,array2,0,HALF);
        // Вычисляем в отдельных потоках
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++) { array1[i] = calculate(array1[i],i); }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++) { array2[i] = calculate(array2[i],i); }
            }
        }.start();
        // Собираем значения из двух массивов обратно в исходный массив
        System.arraycopy(array1,0,array,0,HALF);
        System.arraycopy(array2,0,array,HALF,HALF);
        System.out.println("makeArrayWithThread: время выполнения=" + (System.currentTimeMillis() - startTime) + " милисекунд.");

    }



    // Выполнение вычислений
    private float calculate(float value, float index) {
        return (float)(value * Math.sin(0.2f+index/5) * Math.cos(0.2f+index/5) * Math.cos(0.4f+index/2));
    }

}

package Lesson2;

/**
 * Java. Level 2. Lesson X. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 17.02.2019
 */

public class MyArray {

    // Задаем размерность массива
    private final int ARRAY_SIZE_I = 4;
    private final int ARRAY_SIZE_J = 4;

    private String[][] array;

    public MyArray(String[][] array) {
        this.array = array;
        if (!checkSizeArray()) {
            throw new MyArraySizeException(ARRAY_SIZE_I, ARRAY_SIZE_J);
        }
    }

    // Проверка размерности массива
    private boolean checkSizeArray() {

        if (array.length != ARRAY_SIZE_I) {
            return false;
        } else {
            for (int i = 0; i < ARRAY_SIZE_I; i++) {
                if (array[i].length != ARRAY_SIZE_J) {
                    return false;
                }
            }
        }

        return true;
    }

    public int sumArray() {
        int sum = 0;
        for (int i = 0; i < ARRAY_SIZE_I; i++) {
            for (int j = 0; j < ARRAY_SIZE_J; j++) {
                // Проверка, что элемент массива есть числос использовнием регулярного выражения
                if (!array[i][j].matches("-?\\d+")) {
                    throw new MyArrayDataException(i,j);
                }
                else {
                    sum += Integer.parseInt(array[i][j]);
                }
            }
        }
        return sum;
    }

    public void printArray() {
        System.out.println("Вывод массива размерности " + ARRAY_SIZE_I + "х" + ARRAY_SIZE_J + " :");
        for (int i = 0; i < ARRAY_SIZE_I; i++) {
            for (int j = 0; j < ARRAY_SIZE_J; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
package com.geekbrains;

import com.geekbrains.myException.MyArrayDataException;
import com.geekbrains.myException.MyArraySizeException;

public class Main {

    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
     * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ
     * или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией,
     * в какой именно ячейке лежат неверные данные.
     * 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException
     * и MyArrayDataException и вывести результат расчета (сумму элементов, при условии, что подали на
     * вход корректный массив).
     */

    public static void main(String[] args) {
        String[][] array = {{"1", "2", "1", "5"},
                            {"4", "6", "7", "9"},
                            {"7", "5", "6", "8"},
                            {"4", "2", "2", "0"}};
        try {
            try {
                int result = sumArrays(array);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Change the array.");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Error in cell: " + e.coordinatesOne + "x" + e.coordinatesTwo);
        }
    }

    public static int sumArrays(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return sum;
    }
}


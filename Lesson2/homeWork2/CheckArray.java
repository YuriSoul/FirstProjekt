package java2.Lesson2.homeWork2;

import static java.lang.Integer.valueOf;

public class CheckArray {
    public static void main(String[] args) {
        //Создаем 4 строковых двумерных массива для проверки
        String[][] stringArray0 = new String[][] {
                {"1", "g", "3", "5"},
                {"5", "7", "2", "1"},
                {"1", "2", "8", "9"},
                {"9", "2", "3", "4"}
        };
        String[][] stringArray1 = new String[][] {
                {"8", "1", "2", "4"},
                {"5", "2", "2", "3"},
                {"6", "8", "4", "3"},
                {"2", "1", "5", "4"}
        };
        String[][] stringArray2 = new String[][] {

                {"2", "2", "5", "4"},
                {"5", "f", "6"},
                {"1", "2", "3", "6"},
                {"1", "3", "2", "7"}
        };
        String[][] stringArray3 = new String[][] {
                {"1", "2", "3", "4"},
                {"2", "3", "5", "7"},
                {"1", "2", "3", "4"}
        };

        //Теперь попробуем просуммировать каждый из 4-х массивов методом sumArray()
        //при этом если с шириной массива или типом данных в массиве что-то не так
        //сработает исключение MyArraySizeException или MyArrayDataException
        try {
            System.out.println("Сумма элементов массива равна " + sumArray(stringArray0));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
        try {
            System.out.println("Сумма элементов массива равна " + sumArray(stringArray1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
        try {
            System.out.println("Сумма элементов массива равна " + sumArray(stringArray2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
        try {
            System.out.println("Сумма элементов массива равна " + sumArray(stringArray3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    private static int sumArray (String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int lengthArr = 4;
        int sum = 0;

        // Проверяем, что у массива 4 основных измерения (4 строки)
        if (arr.length != 4) {
            throw new MyArraySizeException(String.format("Не верный размер массива. Размерность должна быть %dх%d.", lengthArr, lengthArr));
        }
        // Проверяем, что в каждой из 4-х строк нашего двумерного массива находится ровно по 4 элемента
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException(String.format("Не верный размер массива. Размерность должна быть %dх%d.", lengthArr, lengthArr));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += valueOf(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В позиции [%d][%d] исходного массива не целое число %s.", i, j, arr[i][j]));
                }
            }
        }
        return sum;
    }
}

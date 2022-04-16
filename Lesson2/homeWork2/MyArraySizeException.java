package java2.Lesson2.homeWork2;

public class MyArraySizeException extends RuntimeException {
    MyArraySizeException(String msg) {
        super("Ошибка размерности массива.\n" + " " + msg);
    }
}

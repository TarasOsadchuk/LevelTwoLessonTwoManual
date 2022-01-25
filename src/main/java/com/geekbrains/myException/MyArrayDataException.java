package com.geekbrains.myException;

public class MyArrayDataException extends Exception {
    public final int coordinatesOne;
    public final int coordinatesTwo;

    public MyArrayDataException(int coordinatesOne, int coordinatesTwo) {
        this.coordinatesOne = coordinatesOne;
        this.coordinatesTwo = coordinatesTwo;
    }
}
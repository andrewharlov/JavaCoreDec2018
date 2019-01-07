package com.epam.javacore.homework01.task05;

import java.util.Scanner;

public class ArrayX {
    public static void main(String[] args){
        int arraySize = 0;

        while (true){
            System.out.print("Please enter a size for the array: ");
            Scanner scanner = new Scanner(System.in);
            String number = scanner.nextLine();

            try {
                arraySize = Integer.parseInt(number);
            } catch (NumberFormatException ex){
                System.out.println("Please use only integer numbers.\n");
            }

            if (arraySize == 0){
                System.out.println("A size for the array can not be 0.\n");
            } else if (arraySize % 2 == 0){
                System.out.println("Please use only odd numbers\n");
            } else {
                break;
            }
        }

        ArrayX arrayX = new ArrayX();
        int[][] array = arrayX.createArray(arraySize);

        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] createArray(int arraySize){
        int[][] array = new int[arraySize][arraySize];

        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                if (i == j || arraySize - i == j + 1){
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
            }
        }

        return array;
    }
}

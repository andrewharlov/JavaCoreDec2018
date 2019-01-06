package com.epam.javacore.homework01.task03;

import java.util.Scanner;

public class TangentFunction {
    public static void main(String[] args){
        double start, end, step;

        while (true){
            System.out.print("Enter numbers a b h: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] numbers = input.split("\\s+");

            try {
                start = Double.parseDouble(numbers[0]);
                end = Double.parseDouble(numbers[1]);
                step = Double.parseDouble(numbers[2]);
                System.out.println("a = " + start);
                System.out.println("b = " + end);
                System.out.println("h = " + step);

                if (start > end){
                    System.out.println("Sorry, 'a' must be less then 'b'. \n");
                } else {
                    break;
                }
            } catch (NumberFormatException ex){
                System.out.println("Please use only numbers.\n");
            }
        }

        TangentFunction tangentFunction = new TangentFunction();

        for (double i = start; i <= end; i += step){
            double result = tangentFunction.function(i);
            System.out.println("x = " + i + " => result = " + result);
        }
    }

    private double function(double x){
        return (Math.tan(2 * x)) - 3;
    }
}

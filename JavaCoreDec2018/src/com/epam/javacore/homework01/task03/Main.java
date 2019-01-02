package com.epam.javacore.homework01.task03;

import java.util.Scanner;

public class Main {
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

        Main main = new Main();
        main.function(start, end, step);
    }

    private void function(double start, double end, double step){
        for (double i = start; i <= end; i += step){
            double result = (Math.tan(2 * i)) - 3;
            System.out.println("x = " + i + " => result = " + result);
        }
    }
}

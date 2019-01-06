package com.epam.javacore.homework01.task04;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SequenceMaximum {
    public static void main(String[] args){
        ArrayList<Double> sequence = new ArrayList<Double>();
        int n = 0;

        System.out.println("Given a sequence (a1, a2, ..., a2n)\n" +
                "of real numbers.\n" +
                "Find the maximum of a sub-sequence " +
                "(a1 + a2n, a2 + a2n-1, ..., an + an+1)\n");

        while (true){
            System.out.print("Please enter a number for the variable 'n': ");
            Scanner scanner = new Scanner(System.in);
            String number = scanner.nextLine();

            try {
                n = Integer.parseInt(number);
            } catch (NumberFormatException ex){
                System.out.println("Please use only integer numbers.\n");
            }

            if (n == 0){
                System.out.println("'n' can not be 0.\n");
            } else {
                break;
            }
        }

        System.out.println("n = " + n);

        for (int i = 0; i < 2 * n; i++){
            double randomDouble = ThreadLocalRandom.current().nextDouble(1, 11);
            randomDouble = new BigDecimal(randomDouble).setScale(1, RoundingMode.HALF_UP).doubleValue();
            sequence.add(randomDouble);
        }

        System.out.print("Sequence: (  ");
        for (double value : sequence){
            System.out.print(value + "  ");
        }
        System.out.println(")");

        SequenceMaximum sequenceMaximum = new SequenceMaximum();
        System.out.println("max = " + sequenceMaximum.max(sequence, n));
    }

    private double max(ArrayList<Double> sequence, int n){
        double max = 0;
        System.out.print("Sub-sequence: (  ");

        for (int i = 0; i < n; i++){
            double value = sequence.get(i) + sequence.get(2 * n - 1 - i);
            value = new BigDecimal(value).setScale(1, RoundingMode.HALF_UP).doubleValue();

            System.out.print(value + "  ");

            if (value > max){
                max = value;
            }
        }

        System.out.println(")");
        return max;
    }
}

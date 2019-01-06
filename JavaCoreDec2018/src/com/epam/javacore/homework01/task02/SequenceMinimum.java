package com.epam.javacore.homework01.task02;

import java.math.BigDecimal;
import java.util.Scanner;

public class SequenceMinimum {
    public static void main(String[] args){
        BigDecimal minValue;
        double epsilon = 0.0;
        int n = 1;

        while (true){
            System.out.println("Enter an epsilon value: ");
            Scanner scanner = new Scanner(System.in);
            String epsilonString = scanner.nextLine();

            try {
                epsilon = Double.parseDouble(epsilonString);
            } catch (NumberFormatException ex){
                System.out.println("Please use only numbers.");
            }

            if (epsilon == 0.0){
                System.out.println("Epsilon can not be 0.");
            } else {
                break;
            }
        }

        SequenceMinimum sequenceMinimum = new SequenceMinimum();
        minValue = sequenceMinimum.function(n, epsilon);
        System.out.println("Minimum value: " + minValue.toPlainString());
    }

    public BigDecimal function(int n, double epsilon){
        double An = 1 / (Math.pow((n + 1), 2));
        BigDecimal min;

        while (true){
            if (An <= epsilon){
                min = new BigDecimal(An);
                break;
            } else {
                System.out.println("Log : a[" + n + "] = " + new BigDecimal(An).toPlainString());
                n++;
                An = 1 / (Math.pow((n + 1), 2));
            }
        }

        return min;
    }
}

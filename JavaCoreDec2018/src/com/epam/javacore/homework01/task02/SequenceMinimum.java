package com.epam.javacore.homework01.task02;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequenceMinimum {
    public List<BigDecimal> sequence = new ArrayList<>();

    public static void main(String[] args){
        BigDecimal minValue;
        double epsilon = 0.0;

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
        minValue = sequenceMinimum.function(epsilon);
        System.out.println("Minimum value: " + minValue.toPlainString());
        sequenceMinimum.printSequence();
    }

    public BigDecimal function(double epsilon){
        int n = 1;
        double An = 1 / (Math.pow((n + 1), 2));
        BigDecimal min;

        while (true){
            if (An <= epsilon){
                min = new BigDecimal(An);
                sequence.add(min);
                break;
            } else {
                sequence.add(new BigDecimal(An));
                n++;
                An = 1 / (Math.pow((n + 1), 2));
            }
        }

        return min;
    }

    public void printSequence(){
        System.out.println("Sequence:");
        for (int i = 0; i < this.sequence.size(); i++){
            System.out.println("Log : a[" + (i + 1) + "] = " + this.sequence.get(i).toPlainString());
        }
    }
}

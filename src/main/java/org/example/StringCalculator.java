package org.example;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbersInExpression){
        if(numbersInExpression.isEmpty()) return 0;

        boolean IsThereJustANumber = numbersInExpression.length() == 1;
        if(IsThereJustANumber)  return Integer.parseInt(numbersInExpression);

        String delimiter = ",";
        numbersInExpression = numbersInExpression.replaceAll("\n",delimiter);
        return Arrays.stream(numbersInExpression.split(delimiter))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

}
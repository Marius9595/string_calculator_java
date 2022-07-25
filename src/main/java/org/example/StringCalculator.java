package org.example;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbersInExpression){
        if(numbersInExpression.isEmpty()) return 0;

        boolean IsThereJustANumber = numbersInExpression.length() == 1;
        if(IsThereJustANumber)  return Integer.parseInt(numbersInExpression);

        return Arrays.stream(numbersInExpression.split(","))
                .map(Integer::parseInt).
                reduce(0, Integer::sum);
    }

}
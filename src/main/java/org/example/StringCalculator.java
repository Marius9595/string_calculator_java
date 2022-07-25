package org.example;

import java.util.Arrays;

public class StringCalculator {
    public int add(String expression){
        if(expression.isEmpty()) return 0;

        boolean IsThereJustANumber = expression.length() == 1;
        if(IsThereJustANumber)  return Integer.parseInt(expression);

        String delimiter = ",";

        if(expression.contains("//")){
            String[] expression_with_command = expression.split("\n",0);
            String command = expression_with_command[0];
            String custom_delimiter = command.replaceFirst("//","");
            expression = expression_with_command[1];
            expression =expression.replaceAll(custom_delimiter,delimiter);
        }

        expression = expression.replaceAll("\n",delimiter);
        return Arrays.stream(expression.split(delimiter))
                .map(Integer::parseInt)
                .filter(number -> {
                    int max_value_handable = 1000;
                    return number < max_value_handable;
                })
                .reduce(0, Integer::sum);
    }

}
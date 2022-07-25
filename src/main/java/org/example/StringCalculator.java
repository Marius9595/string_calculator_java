package org.example;

import java.util.Arrays;

public class StringCalculator {
    public int add(String expression){
        if(expression.isEmpty()) return 0;

        boolean IsThereJustANumber = expression.length() == 1;
        if(IsThereJustANumber)  return Integer.parseInt(expression);

        String default_delimiter = ",";

        expression = replaceCustomDelimiterwithDefault(expression, default_delimiter);

        expression = expression.replaceAll("\n",default_delimiter);
        return Arrays.stream(expression.split(default_delimiter))
                .map(Integer::parseInt)
                .filter(number -> {
                    int max_value_handable = 1000;
                    return number < max_value_handable;
                })
                .reduce(0, Integer::sum);
    }

    private String replaceCustomDelimiterwithDefault(String expression, String delimiter) {
        if(expression.contains("//")){
            String[] expression_with_command = expression.split("\n",0);
            String command_with_delimiter = expression_with_command[0].replaceFirst("//","");
            String custom_delimiter;
            expression = expression_with_command[1];

            if(command_with_delimiter.contains("[")){
                command_with_delimiter = command_with_delimiter.replaceAll("]","");
                custom_delimiter =  command_with_delimiter.replaceAll("\\[","");
            }else{
                custom_delimiter = command_with_delimiter;
            }
            expression = expression.replaceAll(custom_delimiter, delimiter);
        }
        return expression;
    }

}
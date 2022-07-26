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

    private String replaceCustomDelimiterwithDefault(String expression, String default_delimiter) {
        String command = "//";
        if(expression.contains(command)){
            String[] expression_with_command = expression.split("\n",0);
            String custom_delimiter_of_command = expression_with_command[0].replaceFirst(command,"");
            expression = expression_with_command[1];
            if(custom_delimiter_of_command.contains("[")){
                expression = parsing_delimiters_to_default(expression, default_delimiter, custom_delimiter_of_command);
            }else{
                expression = expression.replaceAll(custom_delimiter_of_command, default_delimiter);
            }
        }
        return expression;
    }

    private String parsing_delimiters_to_default(String expression, String default_delimiter, String custom_delimiter_of_command) {
        for (String raw_delimiter: custom_delimiter_of_command.split("]")) {
            String custom_delimiter = raw_delimiter.replaceAll("\\[","");
            expression = expression.replaceAll(custom_delimiter, default_delimiter);
        }
        return expression;
    }

}
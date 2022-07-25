import org.example.StringCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

/*
"" -> 0 OK
"1" -> 1 OK
"1,2,3,4" -> 10 OK
“1\n2,3” ->  6 OK
“1,\n” -> ERROR
“//;\n1;2” -> 3 OK
“negatives not allowed”
"1001,2" -> 2 OK
“//[;;;]/n2;;;2;;;3” -> 7 OK
“//[;][%]\n1;2%3” -> 6
“//[;;;;][%%]\n3;;;2%%3” -> 8
*/


public class StringCalculatorShould {

    private StringCalculator stringCalculator;
    @Before
    public void setUp(){
        stringCalculator = new StringCalculator();
    }

    @Test
    public void parse_an_expression_without_numbers_as_zero (){
        assertThat(stringCalculator.add("")).isEqualTo(0);
    }
    @Test
    public void not_add_an_expression_with_just_a_number (){
        assertThat(stringCalculator.add("1")).isEqualTo(1);
    }
    @Test
    public void add_numbers_separated_by_an_default_delimiter (){
        assertThat(stringCalculator.add("1,2,3,4")).isEqualTo(10);
    }
    @Test
    public void handle_line_breaks_between_numbers_instead_delimiter (){
        assertThat(stringCalculator.add("1\n2,3")).isEqualTo(6);
    }
    @Test
    public void change_the_delimiter_with_a_command (){
        assertThat(stringCalculator.add("//;\n1;2")).isEqualTo(3);
    }
    @Test
    public void not_add_number_bigger_than_1000 (){
        assertThat(stringCalculator.add("1001,2")).isEqualTo(2);
    }
    @Test
    public void handle_custom_delimiter_with_a_repeated_character (){
        assertThat(stringCalculator.add("//[;;;]\n2;;;2;;;3")).isEqualTo(7);
    }
    @Test
    public void handle_multiple_custom_delimiters(){
        assertThat(stringCalculator.add("//[;][%]\\n1;2%3")).isEqualTo(6);
    }
}

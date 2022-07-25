import org.example.StringCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

/*
"" -> 0 OK
"1" -> 1
"1,2" -> 3
"1,2,3,4" -> 10
“1\n2,3” ->  6
“1,\n” -> ERROR
“//;\n1;2” -> 3
“negatives not allowed”
"1001,2" -> 2
“//[***]\n2***2***3” -> 7
“//[*][%]\n1*2%3” -> 6
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
}

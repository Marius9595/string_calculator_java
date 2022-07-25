import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
"" -> 0
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
    @Test
    public void foo(){
        assertThat(true).isEqualTo(false);
    }
}

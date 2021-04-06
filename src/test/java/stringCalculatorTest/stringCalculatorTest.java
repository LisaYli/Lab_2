package stringCalculatorTest;

import org.junit.jupiter.api.Test;
import stringCalculator.StringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Step 9
Make sure you can also handle multiple delimiters with length longer than one char
 */

public class stringCalculatorTest {

    StringCalculator calc = new StringCalculator();
    String numbers;

    @Test
    public void addTwoNumbers() {
        numbers = "5,5";
        assertEquals(10, calc.add(numbers));

    }

    @Test
    public void addMoreThanTwoNumbers() {
        numbers = "5,5;5,5/5,5";
        assertEquals(30, calc.add(numbers));
    }

    @Test
    public void emptyStringShouldReturnZero() {
        numbers = "";
        assertEquals(0, calc.add(numbers));
    }


    @Test
    public void supportDifferentAndManyDelimiters() {
        numbers = "5\n5//-5\n\n-10,,,,,5";

        assertEquals(15, calc.add(numbers));
    }


    @Test
    public void testOnlyAddAllowedNumbersWhileNegativesThrowException() {
        numbers = "-10,5,5,-5,-89,-25550;-5";
        assertEquals(10, calc.add(numbers));

    }



    @Test
    public void Numbersbiggerthan1000shouldbeignored() {

        numbers = "5,1001;-2";
        assertEquals(5, calc.add(numbers));


    }

    @Test
    public void negativeNumbersShouldGiveARuntimeException() {
        numbers = "-10";

    }


}



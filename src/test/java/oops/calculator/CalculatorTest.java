package oops.calculator;

import oops.calculator.Operator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {



    @Test
    public void parseOperator() {
        assertEquals(Operator.ADD, new Calculator().parseOperator("+"));
        assertEquals(Operator.SUBTRACT, new Calculator().parseOperator("-"));
        assertEquals(Operator.MULTIPLY, new Calculator().parseOperator("*"));
        assertEquals(Operator.DIVIDE, new Calculator().parseOperator("/"));
    }
}
package unittests.computationtests;

import calculator.Calculator;
import calculator.ExecutionContext;
import calculator.Factory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ComputationTest {

    Factory factory = Factory.getInstance();
    private static final Logger logger = Logger.getLogger(ComputationTest.class);
    public ComputationTest() throws ReflectiveOperationException, IOException {}

    @Test(groups = "Computation")
    public void IntComputation() {
        logger.log(Level.INFO, "Int computation test started...");
        String intPrint = """
                PUSH 2
                PUSH 149
                PUSH 212
                +
                SQRT
                PUSH 198
                *
                /
                PRINT""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(intPrint.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        assertEquals(1881, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for int computation successfully finished.");
    }
    @Test(groups = "Computation")
    public void DoubleComputation() {
        logger.log(Level.INFO, "Double computation test started...");
        String intPrint = """
                PUSH 12.25
                PUSH 29.75
                -
                PUSH 4.6
                *
                PUSH 0.5
                +
                SQRT
                DEFINE a 9
                PUSH 9
                -
                PRINT""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(intPrint.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        assertEquals(0, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for double computation successfully finished.");
    }
    @Test(groups = "Computation")
    public void DefineComputation() {
        logger.log(Level.INFO, "Double computation test started...");
        String intPrint = """
                DEFINE a 107.1
                DEFINE b 1927.8
                DEFINE c 17
                DEFINE d 101.5
                PUSH a
                PUSH b
                /
                PUSH c
                +
                PUSH d
                *
                SQRT
                PRINT""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(intPrint.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        assertEquals(59.602852280742404, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for double computation successfully finished.");
    }
}
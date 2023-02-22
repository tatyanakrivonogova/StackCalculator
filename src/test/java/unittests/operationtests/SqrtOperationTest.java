package unittests.operationtests;

import calculator.Calculator;
import calculator.ExecutionContext;
import calculator.Factory;
import factoryExceptions.FactoryException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.assertEquals;

public class SqrtOperationTest {
    private static final Logger logger = Logger.getLogger(AddOperationTest.class);

    public SqrtOperationTest() throws FactoryException {
        Factory.getInstance();
    }

    @Test(groups = "Sqrt")
    public void intSqrt() {
        logger.log(Level.INFO, "Test for int sqrt operation started...");
        String intSqrt = """
        PUSH 289
        SQRT""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(intSqrt.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(17, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for int sqrt operation successfully finished.");
    }
    @Test(groups = "Sqrt")
    public void negativeIntSqrt() {
        logger.log(Level.INFO, "Test for negative int sqrt operation started...");
        String negativeIntSqrt = """
        PUSH -289
        SQRT""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeIntSqrt.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(-289, calculator.getExecutionContext().getStack().peek());
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for negative int sqrt operation successfully finished.");
    }
    @Test(groups = "Sqrt")
    public void doubleSqrt() {
        logger.log(Level.INFO, "Test for double sqrt operation started...");
        String doubleSqrt = """
        PUSH 182.25
        SQRT""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(doubleSqrt.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(13.5, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for double sqrt operation successfully finished.");
    }
    @Test(groups = "Sqrt")
    public void negativeDoubleSqrt() {
        logger.log(Level.INFO, "Test for negative double sqrt operation started...");
        String negativeDoubleSqrt = """
        PUSH -182.25
        SQRT""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeDoubleSqrt.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(-182.25, calculator.getExecutionContext().getStack().peek());
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for negative double sqrt operation successfully finished.");
    }
    @Test(groups = "Sqrt")
    public void zeroSqrt() {
        logger.log(Level.INFO, "Test for zero sqrt operation started...");
        String zeroSqrt = """
        PUSH 0
        SQRT""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(zeroSqrt.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for zero sqrt operation successfully finished.");
    }
    @Test(groups = "Sqrt")
    public void emptySqrt() {
        logger.log(Level.INFO, "Test for empty sqrt operation started...");
        String emptySqrt = """
        SQRT""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(emptySqrt.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for empty sqrt operation successfully finished.");
    }
}

package unittests.operationtests;

import calculator.Calculator;
import calculator.ExecutionContext;
import calculator.Factory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class MulOperationTest {

    Factory factory = Factory.getInstance();
    private static final Logger logger = Logger.getLogger(AddOperationTest.class);

    public MulOperationTest() throws ReflectiveOperationException, IOException {}

    @Test(groups = "Mul")
    public void intMul() {
        logger.log(Level.INFO, "Test for int mul operation started...");
        String intMul = """
        PUSH 97
        PUSH 28
        *""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(intMul.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(2716, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for int mul operation successfully finished.");
    }
    @Test(groups = "Mul")
    public void negativeIntMul() {
        logger.log(Level.INFO, "Test for negative int mul operation started...");
        String negativeIntMul = """
        PUSH 97
        PUSH -28
        *""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeIntMul.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(-2716, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for negative int mul operation successfully finished.");
    }
    @Test(groups = "Mul")
    public void doubleMul() {
        logger.log(Level.INFO, "Test for double mul operation started...");
        String doubleMul = """
        PUSH 46.58
        PUSH 36.4
        *""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(doubleMul.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(1695.512, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for double mul operation successfully finished.");
    }
    @Test(groups = "Mul")
    public void negativeDoubleMul() {
        logger.log(Level.INFO, "Test for negative double mul operation started...");
        String negativeDoubleMul = """
        PUSH 46.58
        PUSH -36.4
        *""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeDoubleMul.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(-1695.512, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for negative double mul operation successfully finished.");
    }
    @Test(groups = "Mul")
    public void zeroMul() {
        logger.log(Level.INFO, "Test for zero mul operation started...");
        String zeroMul = """
        PUSH 6
        PUSH 0
        *""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(zeroMul.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for zero mul operation successfully finished.");
    }
    @Test(groups = "Mul")
    public void notEnoughArgumentsMul() {
        logger.log(Level.INFO, "Test for not enough arguments mul operation started...");
        String notEnoughArgumentsMul = """
        PUSH 2.5
        *""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(notEnoughArgumentsMul.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(2.5, calculator.getExecutionContext().getStack().peek());
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for not enough arguments mul operation successfully finished.");
    }
    @Test(groups = "Mul")
    public void emptyMul() {
        logger.log(Level.INFO, "Test for empty mul operation started...");
        String emptyMul = """
        *""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(emptyMul.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for empty mul operation successfully finished.");
    }
}

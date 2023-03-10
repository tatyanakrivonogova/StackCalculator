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

public class DivOperationTest {
    private static final Logger logger = Logger.getLogger(AddOperationTest.class);

    public DivOperationTest() throws FactoryException {
        Factory.getInstance();
    }

    @Test(groups = "Div")
    public void intDiv() {
        logger.log(Level.INFO, "Test for int div operation started...");
        String intDiv = """
        PUSH 5
        PUSH 18
        /""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(intDiv.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(3.6, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for int div operation successfully finished.");
    }
    @Test(groups = "Div")
    public void negativeIntDiv() {
        logger.log(Level.INFO, "Test for negative int div operation started...");
        String negativeIntDiv = """
        PUSH 18
        PUSH -5
        /""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeIntDiv.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(-0.2777777777777778, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for negative int div operation successfully finished.");
    }
    @Test(groups = "Div")
    public void doubleDiv() {
        logger.log(Level.INFO, "Test for double div operation started...");
        String doubleDiv = """
        PUSH 8.7
        PUSH 109.62
        /""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(doubleDiv.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(12.600000000000001, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for double div operation successfully finished.");
    }
    @Test(groups = "Div")
    public void negativeDoubleDiv() {
        logger.log(Level.INFO, "Test for negative double div operation started...");
        String negativeDoubleDiv = """
        PUSH 8.7
        PUSH -109.62
        /""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeDoubleDiv.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(-12.600000000000001, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for negative double div operation successfully finished.");
    }
    @Test(groups = "Div")
    public void zero1Div() {
        logger.log(Level.INFO, "Test for zero first div operation started...");
        String zeroDiv = """
        PUSH 6
        PUSH 0
        /""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(zeroDiv.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for zero first div operation successfully finished.");
    }
    @Test(groups = "Div")
    public void zero2Div() {
        logger.log(Level.INFO, "Test for zero second div operation started...");
        String zeroDiv = """
        PUSH 0
        PUSH 6
        /""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(zeroDiv.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(2, calculator.getExecutionContext().getStack().size());
        assertEquals(6, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for zero second div operation successfully finished.");
    }
    @Test(groups = "Div")
    public void notEnoughArgumentsDiv() {
        logger.log(Level.INFO, "Test for not enough arguments div operation started...");
        String notEnoughArgumentsDiv = """
        PUSH 2.5
        /""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(notEnoughArgumentsDiv.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(2.5, calculator.getExecutionContext().getStack().peek());
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for not enough arguments div operation successfully finished.");
    }
    @Test(groups = "Div")
    public void emptyDiv() {
        logger.log(Level.INFO, "Test for empty div operation started...");
        String emptyDiv = """
        /""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(emptyDiv.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for empty div operation successfully finished.");
    }
}

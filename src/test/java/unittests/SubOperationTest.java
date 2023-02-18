package unittests;

import calculator.Calculator;
import calculator.ExecutionContext;
import calculator.Factory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class SubOperationTest {

    Factory factory = new Factory("config.properties");
    private static final Logger logger = Logger.getLogger(AddOperationTest.class);

    public SubOperationTest() throws ReflectiveOperationException, IOException {}

    @Test
    public void intSub() {
        logger.log(Level.INFO, "Test for int sub operation started...");
        String intSub = """
        PUSH 879
        PUSH 3756
        -""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(intSub.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(2877, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for int sub operation successfully finished.");
    }
    @Test
    public void negativeIntSub() {
        logger.log(Level.INFO, "Test for negative int sub operation started...");
        String negativeIntSub = """
        PUSH 10
        PUSH -8
        -""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeIntSub.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(-18, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for negative int sub operation successfully finished.");
    }
    @Test
    public void doubleSub() {
        logger.log(Level.INFO, "Test for double sub operation started...");
        String doubleSub = """
        PUSH 9.84570
        PUSH 13.9587704
        -""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(doubleSub.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(4.1130704, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for double sub operation successfully finished.");
    }
    @Test
    public void negativeDoubleSub() {
        logger.log(Level.INFO, "Test for negative double sub operation started...");
        String negativeDoubleSub = """
        PUSH -13.9587704
        PUSH 9.84570
        -""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeDoubleSub.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(23.8044704, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for negative double sub operation successfully finished.");
    }
    @Test
    public void notEnoughArgumentsSub() {
        logger.log(Level.INFO, "Test for not enough arguments sub operation started...");
        String notEnoughArgumentsSub = """
        PUSH 2.5
        -""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(notEnoughArgumentsSub.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(2.5, calculator.getExecutionContext().getStack().peek());
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for not enough arguments sub operation successfully finished.");
    }
    @Test
    public void emptySub() {
        logger.log(Level.INFO, "Test for empty sub operation started...");
        String emptySub = """
        -""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(emptySub.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for empty sub operation successfully finished.");
    }
}

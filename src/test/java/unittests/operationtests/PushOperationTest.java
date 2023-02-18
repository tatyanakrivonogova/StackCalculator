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

public class PushOperationTest {
    Factory factory = Factory.getInstance();
    private static final Logger logger = Logger.getLogger(PushOperationTest.class);
    public PushOperationTest() throws ReflectiveOperationException, IOException {}

    @Test(groups = "Push")
    public void simplePush() {
        logger.log(Level.INFO, "Test for simple push operation started...");
        String intPush = """
                PUSH 5""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(intPush.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        assertEquals(5, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for simple push operation successfully finished.");
    }

    @Test(groups = "Push")
    public void emptyPush() {
        logger.log(Level.INFO, "Test for empty push operation started...");
        String doublePush = """
                PUSH""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(doublePush.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for empty push operation successfully finished.");
    }
    @Test(groups = "Push")
    public void afterDefinePush() {
        logger.log(Level.INFO, "Test for after define push operation started...");
        String doublePush = """
                DEFINE a 9
                PUSH a""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(doublePush.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        assertEquals(9, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for after define push operation successfully finished.");
    }
    @Test(groups = "Push")
    public void withoutDefinePush() {
        logger.log(Level.INFO, "Test for without define push operation started...");
        String doublePush = """
                PUSH 4
                PUSH a""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(doublePush.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        assertEquals(4, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for without define push operation successfully finished.");
    }
}
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

public class PopOperationTest {

    Factory factory = Factory.getInstance();
    private static final Logger logger = Logger.getLogger(PopOperationTest.class);

    public PopOperationTest() throws ReflectiveOperationException, IOException {
    }

    @Test(groups = "Pop")
    public void simplePop() {
        logger.log(Level.INFO, "Test for simple pop operation started...");
        String intPop = """
                PUSH 5
                PUSH 2
                POP""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(intPop.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        assertEquals(5, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for simple pop operation successfully finished.");
    }

    @Test(groups = "Pop")
    public void emptyPop() {
        logger.log(Level.INFO, "Test for empty pop operation started...");
        String doublePop = """
                POP""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(doublePop.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for empty pop operation successfully finished.");
    }
}
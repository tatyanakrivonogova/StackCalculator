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

public class PrintOperationTest {

    Factory factory = new Factory("config.properties");
    private static final Logger logger = Logger.getLogger(PrintOperationTest.class);

    public PrintOperationTest() throws ReflectiveOperationException, IOException {
    }

    @Test
    public void simplePrint() {
        logger.log(Level.INFO, "Test for simple print operation started...");
        String intPrint = """
                PUSH 5
                PRINT""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(intPrint.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        assertEquals(5, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for simple print operation successfully finished.");
    }

    @Test
    public void emptyPrint() {
        logger.log(Level.INFO, "Test for empty print operation started...");
        String doublePrint = """
                PRINT""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(doublePrint.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for empty print operation successfully finished.");
    }

    @Test
    public void errorPrint() {
        logger.log(Level.INFO, "Test for error print operation started...");
        String negativeDoublePrint = """
                DEFINE a 3
                PUSH a
                PRINT a""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeDoublePrint.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        assertEquals(3, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for error print operation successfully finished.");
    }
}
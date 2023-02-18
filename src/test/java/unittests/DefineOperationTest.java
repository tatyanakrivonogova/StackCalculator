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

public class DefineOperationTest {

    Factory factory = Factory.getInstance();
    private static final Logger logger = Logger.getLogger(DefineOperationTest.class);

    public DefineOperationTest() throws ReflectiveOperationException, IOException {
    }

    @Test
    public void simpleDefine() {
        logger.log(Level.INFO, "Test for simple define operation started...");
        String intDefine = """
                DEFINE a 8
                PUSH a""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(intDefine.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(8, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for simple define operation successfully finished.");
    }

    @Test
    public void repeatDefine() {
        logger.log(Level.INFO, "Test for repeat define operation started...");
        String negativeIntDefine = """
                DEFINE a 8
                PUSH a
                PUSH 1
                DEFINE a 9
                +""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeIntDefine.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(9, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for repeat define operation successfully finished.");
    }

    @Test
    public void emptyDefine() {
        logger.log(Level.INFO, "Test for empty define operation started...");
        String doubleDefine = """
                DEFINE a
                PUSH a""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(doubleDefine.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for empty define operation successfully finished.");
    }

    @Test
    public void errorDefine() {
        logger.log(Level.INFO, "Test for error define operation started...");
        String negativeDoubleDefine = """
                DEFINE a x""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeDoubleDefine.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for error define operation successfully finished.");
    }
}
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

public class AddOperationTest {
    private static final Logger logger = Logger.getLogger(AddOperationTest.class);

    public AddOperationTest() throws FactoryException {
        Factory.getInstance();
    }

    @Test(groups = "Add")
    public void intAdd() {
        logger.log(Level.INFO, "Test for int add operation started...");
        String intAdd = """
        PUSH 10
        PUSH 156
        +""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(intAdd.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(166, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for int add operation successfully finished.");
    }
    @Test(groups = "Add")
    public void negativeIntAdd() {
        logger.log(Level.INFO, "Test for negative int add operation started...");
        String negativeIntAdd = """
        PUSH 10
        PUSH -8
        +""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeIntAdd.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(2, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for negative int add operation successfully finished.");
    }
    @Test(groups = "Add")
    public void doubleAdd() {
        logger.log(Level.INFO, "Test for double add operation started...");
        String doubleAdd = """
        PUSH 13.9587704
        PUSH 9.84570
        +""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(doubleAdd.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(23.8044704, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for double add operation successfully finished.");
    }
    @Test(groups = "Add")
    public void negativeDoubleAdd() {
        logger.log(Level.INFO, "Test for negative double add operation started...");
        String negativeDoubleAdd = """
        PUSH -13.9587704
        PUSH 9.84570
        +""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(negativeDoubleAdd.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(-4.1130704, calculator.getExecutionContext().getStack().peek());
        logger.log(Level.INFO, "Test for negative double add operation successfully finished.");
    }
    @Test(groups = "Add")
    public void notEnoughArgumentsAdd() {
        logger.log(Level.INFO, "Test for not enough arguments add operation started...");
        String notEnoughArgumentsAdd = """
        PUSH 2.5
        +""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(notEnoughArgumentsAdd.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(2.5, calculator.getExecutionContext().getStack().peek());
        assertEquals(1, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for not enough arguments add operation successfully finished.");
    }
    @Test(groups = "Add")
    public void emptyAdd() {
        logger.log(Level.INFO, "Test for empty add operation started...");
        String emptyAdd = """
        +""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(emptyAdd.getBytes()), new ExecutionContext(), logger);
        calculator.calculate();
        assertEquals(0, calculator.getExecutionContext().getStack().size());
        logger.log(Level.INFO, "Test for empty add operation successfully finished.");
    }
}

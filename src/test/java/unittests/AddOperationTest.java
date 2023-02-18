package unittests;

import calculator.Calculator;
import calculator.ExecutionContext;
import calculator.Factory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class AddOperationTest {

    Factory factory;
    private static final Logger logger = Logger.getLogger(AddOperationTest.class);
    @BeforeTest
    public void createFactory() throws ReflectiveOperationException, IOException {
        factory = new Factory("config.properties");
    }

    @Test
    public void firstAdd() {
        logger.log(Level.INFO, "Test for add operation started...");
        String firstAdd = """
        PUSH 10
        PUSH 156
        +""";
        Calculator calculator = new Calculator(new ByteArrayInputStream(firstAdd.getBytes()), factory, new ExecutionContext(), logger);
        calculator.calculate();
        logger.log(Level.INFO, "Test for add operation finished.");
        assertEquals(15, calculator.getExecutionContext().getStack().peek());
    }
}

package unittests.exceptionstests;

import calculator.ExecutionContext;
import calculator.Factory;
import calculatorExceptions.argumentsExceptions.InvalidDefineArgument;
import calculatorExceptions.argumentsExceptions.InvalidNumberOfArguments;
import calculatorExceptions.argumentsExceptions.InvalidSqrtArgument;
import calculatorExceptions.argumentsExceptions.UndeclaredVariable;
import calculatorExceptions.arithmeticExceptions.DivisionByZero;
import calculatorExceptions.stackExceptions.NotEnoughElementsOnStack;
import calculatorExceptions.stackExceptions.StackIsEmpty;
import factoryExceptions.FactoryException;
import factoryExceptions.UnknownOperation;
import operations.Operation;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import unittests.operationtests.AddOperationTest;

import static org.testng.Assert.assertThrows;

public class ExceptionsTest {
    private static final Logger logger = Logger.getLogger(AddOperationTest.class);
    public ExceptionsTest() throws FactoryException {
        Factory.getInstance();
    }

    @Test(groups = "exceptions")
    public void AddNotEnoughElementsOnStackException() throws FactoryException {
        logger.log(Level.INFO, "Test for not enough arguments exception for add started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(2.5);
        String[] args = {"+"};
        Operation add = (Operation) Factory.getOperation("+");
        assertThrows(NotEnoughElementsOnStack.class, () -> add.execute(args, executionContext));
        logger.log(Level.INFO, "Test for not enough arguments exception for add successfully finished.");
    }

    @Test(groups = "exceptions")
    public void AddInvalidNumberOfArgumentsException() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid number of arguments exception for add started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(2.5);
        executionContext.getStack().push(3.5);
        String[] args = {"+", "10"};
        Operation add = (Operation) Factory.getOperation("+");
        assertThrows(InvalidNumberOfArguments.class, () -> add.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid number of arguments exception for add finished.");
    }
    @Test(groups = "exceptions")
    public void DefineInvalidNumberOfArgumentsException1() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid number of arguments exception for define started...");
        ExecutionContext executionContext = new ExecutionContext();
        String[] args = {"DEFINE", "a"};
        Operation define = (Operation) Factory.getOperation("DEFINE");
        assertThrows(InvalidNumberOfArguments.class, () -> define.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid number of arguments exception for add finished.");
    }
    @Test(groups = "exceptions")
    public void DefineInvalidNumberOfArgumentsException2() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid number of arguments exception for define started...");
        ExecutionContext executionContext = new ExecutionContext();
        String[] args = {"DEFINE", "a", "4", "5"};
        Operation define = (Operation) Factory.getOperation("DEFINE");
        assertThrows(InvalidNumberOfArguments.class, () -> define.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid number of arguments exception for add finished.");
    }
    @Test(groups = "exceptions")
    public void DefineInvalidNumberOfArgumentsException3() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid number of arguments exception for define started...");
        ExecutionContext executionContext = new ExecutionContext();
        String[] args = {"DEFINE"};
        Operation define = (Operation) Factory.getOperation("DEFINE");
        assertThrows(InvalidNumberOfArguments.class, () -> define.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid number of arguments exception for add finished.");
    }
    @Test(groups = "exceptions")
    public void InvalidDefineArgumentException1() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid define argument started...");
        ExecutionContext executionContext = new ExecutionContext();
        String[] args = {"DEFINE", "4", "5"};
        Operation define = (Operation) Factory.getOperation("DEFINE");
        assertThrows(InvalidDefineArgument.class, () -> define.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid define argument finished.");
    }
    @Test(groups = "exceptions")
    public void InvalidDefineArgumentException2() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid define argument started...");
        ExecutionContext executionContext = new ExecutionContext();
        String[] args = {"DEFINE", "4", "a"};
        Operation define = (Operation) Factory.getOperation("DEFINE");
        assertThrows(InvalidDefineArgument.class, () -> define.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid define argument finished.");
    }
    @Test(groups = "exceptions")
    public void InvalidDefineArgumentException3() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid define argument started...");
        ExecutionContext executionContext = new ExecutionContext();
        String[] args = {"DEFINE", "a", "b"};
        Operation define = (Operation) Factory.getOperation("DEFINE");
        assertThrows(InvalidDefineArgument.class, () -> define.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid define argument finished.");
    }
    @Test(groups = "exceptions")
    public void DivNotEnoughElementsOnStackException() throws FactoryException {
        logger.log(Level.INFO, "Test for not enough arguments exception for div started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(2.5);
        String[] args = {"/"};
        Operation div = (Operation) Factory.getOperation("/");
        assertThrows(NotEnoughElementsOnStack.class, () -> div.execute(args, executionContext));
        logger.log(Level.INFO, "Test for not enough arguments exception for div successfully finished.");
    }
    @Test(groups = "exceptions")
    public void DivInvalidNumberOfArgumentsException() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid number of arguments exception for div started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(10.0);
        executionContext.getStack().push(2.5);
        String[] args = {"/", "10"};
        Operation div = (Operation) Factory.getOperation("/");
        assertThrows(InvalidNumberOfArguments.class, () -> div.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid number of arguments exception for div finished.");
    }
    @Test(groups = "exceptions")
    public void DivisionByZeroException() throws FactoryException {
        logger.log(Level.INFO, "Test for division by zero exception started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(0.0);
        executionContext.getStack().push(2.5);
        String[] args = {"/"};
        Operation div = (Operation) Factory.getOperation("/");
        assertThrows(DivisionByZero.class, () -> div.execute(args, executionContext));
        logger.log(Level.INFO, "Test for division by zero exception finished.");
    }
    @Test(groups = "exceptions")
    public void MulNotEnoughElementsOnStackException() throws FactoryException {
        logger.log(Level.INFO, "Test for not enough arguments exception for mul started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(2.5);
        String[] args = {"*"};
        Operation mul = (Operation) Factory.getOperation("*");
        assertThrows(NotEnoughElementsOnStack.class, () -> mul.execute(args, executionContext));
        logger.log(Level.INFO, "Test for not enough arguments exception for mul successfully finished.");
    }

    @Test(groups = "exceptions")
    public void MulInvalidNumberOfArgumentsException() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid number of arguments exception for mul started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(2.5);
        executionContext.getStack().push(3.5);
        String[] args = {"*", "10"};
        Operation mul = (Operation) Factory.getOperation("*");
        assertThrows(InvalidNumberOfArguments.class, () -> mul.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid number of arguments exception for mul finished.");
    }
    @Test(groups = "exceptions")
    public void PopInvalidNumberOfArgumentsException() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid number of arguments exception for pop started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(1.0);
        String[] args = {"POP", "10"};
        Operation pop = (Operation) Factory.getOperation("POP");
        assertThrows(InvalidNumberOfArguments.class, () -> pop.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid number of arguments exception for pop finished.");
    }
    @Test(groups = "exceptions")
    public void PopStackIsEmptyException() throws FactoryException {
        logger.log(Level.INFO, "Test for stack is empty exception for pop started...");
        ExecutionContext executionContext = new ExecutionContext();
        String[] args = {"POP"};
        Operation pop = (Operation) Factory.getOperation("POP");
        assertThrows(StackIsEmpty.class, () -> pop.execute(args, executionContext));
        logger.log(Level.INFO, "Test for stack is empty exception for pop finished.");
    }
    @Test(groups = "exceptions")
    public void PrintInvalidNumberOfArgumentsException() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid number of arguments exception for print started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(1.0);
        String[] args = {"PRINT", "10"};
        Operation print = (Operation) Factory.getOperation("PRINT");
        assertThrows(InvalidNumberOfArguments.class, () -> print.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid number of arguments exception for print finished.");
    }
    @Test(groups = "exceptions")
    public void PrintStackIsEmptyException() throws FactoryException {
        logger.log(Level.INFO, "Test for stack is empty exception for print started...");
        ExecutionContext executionContext = new ExecutionContext();
        String[] args = {"PRINT"};
        Operation print = (Operation) Factory.getOperation("PRINT");
        assertThrows(StackIsEmpty.class, () -> print.execute(args, executionContext));
        logger.log(Level.INFO, "Test for stack is empty exception for print finished.");
    }
    @Test(groups = "exceptions")
    public void PushInvalidNumberOfArgumentsException1() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid number of arguments exception for push started...");
        ExecutionContext executionContext = new ExecutionContext();
        String[] args = {"PUSH"};
        Operation push = (Operation) Factory.getOperation("PUSH");
        assertThrows(InvalidNumberOfArguments.class, () -> push.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid number of arguments exception for push finished.");
    }
    @Test(groups = "exceptions")
    public void PushInvalidNumberOfArgumentsException2() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid number of arguments exception for push started...");
        ExecutionContext executionContext = new ExecutionContext();
        String[] args = {"PUSH", "5", "7"};
        Operation push = (Operation) Factory.getOperation("PUSH");
        assertThrows(InvalidNumberOfArguments.class, () -> push.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid number of arguments exception for push finished.");
    }
    @Test(groups = "exceptions")
    public void PushUndeclaredVariableException1() throws FactoryException {
        logger.log(Level.INFO, "Test for undeclared push variable started...");
        ExecutionContext executionContext = new ExecutionContext();
        String[] args = {"PUSH", "a"};
        Operation push = (Operation) Factory.getOperation("PUSH");
        assertThrows(UndeclaredVariable.class, () -> push.execute(args, executionContext));
        logger.log(Level.INFO, "Test for undeclared push variable finished.");
    }
    @Test(groups = "exceptions")
    public void SqrtNotEnoughElementsOnStackException() throws FactoryException {
        logger.log(Level.INFO, "Test for not enough arguments exception for sqrt started...");
        ExecutionContext executionContext = new ExecutionContext();
        String[] args = {"SQRT"};
        Operation sqrt = (Operation) Factory.getOperation("SQRT");
        assertThrows(NotEnoughElementsOnStack.class, () -> sqrt.execute(args, executionContext));
        logger.log(Level.INFO, "Test for not enough arguments exception for sqrt successfully finished.");
    }
    @Test(groups = "exceptions")
    public void SqrtInvalidNumberOfArgumentsException() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid number of arguments exception for sqrt started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(10.0);
        executionContext.getStack().push(2.5);
        String[] args = {"SQRT", "10"};
        Operation div = (Operation) Factory.getOperation("SQRT");
        assertThrows(InvalidNumberOfArguments.class, () -> div.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid number of arguments exception for sqrt finished.");
    }
    @Test(groups = "exceptions")
    public void InvalidSqrtArgumentException() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid sqrt exception started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(-9.0);
        String[] args = {"SQRT"};
        Operation sqrt = (Operation) Factory.getOperation("SQRT");
        assertThrows(InvalidSqrtArgument.class, () -> sqrt.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid sqrt exception finished.");
    }
    @Test(groups = "exceptions")
    public void SubNotEnoughElementsOnStackException() throws FactoryException {
        logger.log(Level.INFO, "Test for not enough arguments exception for sub started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(2.5);
        String[] args = {"-"};
        Operation sub = (Operation) Factory.getOperation("-");
        assertThrows(NotEnoughElementsOnStack.class, () -> sub.execute(args, executionContext));
        logger.log(Level.INFO, "Test for not enough arguments exception for sub successfully finished.");
    }

    @Test(groups = "exceptions")
    public void SubInvalidNumberOfArgumentsException() throws FactoryException {
        logger.log(Level.INFO, "Test for invalid number of arguments exception for sub started...");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(2.5);
        executionContext.getStack().push(3.5);
        String[] args = {"-", "10"};
        Operation sub = (Operation) Factory.getOperation("-");
        assertThrows(InvalidNumberOfArguments.class, () -> sub.execute(args, executionContext));
        logger.log(Level.INFO, "Test for invalid number of arguments exception for add finished.");
    }
    @Test(groups = "exceptions")
    public void UnknownOperationException() {
        logger.log(Level.INFO, "Test for unknown operation exception started...");
        assertThrows(UnknownOperation.class, () -> Factory.getOperation("PLUS"));
        assertThrows(UnknownOperation.class, () -> Factory.getOperation("9.0"));
        assertThrows(UnknownOperation.class, () -> Factory.getOperation("print"));
        assertThrows(UnknownOperation.class, () -> Factory.getOperation("ADD"));

        logger.log(Level.INFO, "Test for unknown operation exception finished.");
    }
}

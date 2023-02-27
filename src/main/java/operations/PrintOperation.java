package operations;
import calculatorExceptions.*;
import calculator.ExecutionContext;
import calculatorExceptions.argumentsExceptions.InvalidNumberOfArguments;
import calculatorExceptions.stackExceptions.StackIsEmpty;

public class PrintOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 1) {
            throw new InvalidNumberOfArguments(args[0], args.length-1, 0);
        }
        if (executionContext.getStack().isEmpty()) {
            throw new StackIsEmpty();
        }
        System.out.println(executionContext.getStack().peek());
    }
}

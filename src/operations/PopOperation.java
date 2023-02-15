package operations;
import calculatorExceptions.*;
import calculator.ExecutionContext;
import calculatorExceptions.operationExceptions.InvalidNumberOfArguments;
import calculatorExceptions.operationExceptions.StackIsEmpty;

public class PopOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 1) {
            throw new InvalidNumberOfArguments((String) args[0], args.length, 1);
        }
        if (executionContext.getStack().isEmpty()) {
            throw new StackIsEmpty();
        }
        executionContext.getStack().pop();
    }
}

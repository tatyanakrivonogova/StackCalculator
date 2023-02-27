package operations;
import calculatorExceptions.*;
import calculator.ExecutionContext;
import calculatorExceptions.argumentsExceptions.InvalidNumberOfArguments;
import calculatorExceptions.stackExceptions.NotEnoughElementsOnStack;

public class SubOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 1) {
            throw new InvalidNumberOfArguments(args[0], args.length-1, 0);
        }
        if (executionContext.getStack().size() < 2) {
            throw new NotEnoughElementsOnStack();
        }
        Double arg1 = executionContext.getStack().pop();
        Double arg2 = executionContext.getStack().pop();
        executionContext.getStack().push(arg1-arg2);
    }
}

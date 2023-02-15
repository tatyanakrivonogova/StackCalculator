package operations;
import calculatorExceptions.*;
import calculator.ExecutionContext;
import calculatorExceptions.operationExceptions.InvalidNumberOfArguments;
import calculatorExceptions.operationExceptions.NotEnoughElementsOnStack;

public class MulOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 1) {
            throw new InvalidNumberOfArguments((String) args[0], args.length, 1);
        }
        if (executionContext.getStack().size() < 2) {
            throw new NotEnoughElementsOnStack();
        }
        Double arg1 = executionContext.getStack().pop();
        Double arg2 = executionContext.getStack().pop();
        executionContext.getStack().push(arg1*arg2);
    }
}

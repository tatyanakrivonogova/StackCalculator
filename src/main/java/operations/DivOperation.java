package operations;
import calculatorExceptions.*;
import calculator.ExecutionContext;
import calculatorExceptions.arithmeticExceptions.DivisionByZero;
import calculatorExceptions.argumentsExceptions.InvalidNumberOfArguments;
import calculatorExceptions.stackExceptions.NotEnoughElementsOnStack;

public class DivOperation implements Operation {
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
        if (arg2.equals(0.0)) {
            executionContext.getStack().push(arg2);
            executionContext.getStack().push(arg1);
            throw new DivisionByZero();
        }
        executionContext.getStack().push(arg1/arg2);
    }
}

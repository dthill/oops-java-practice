package oops.calculator;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Calculator().calculate();
    }

    void calculate() {
        System.out.print("First number: ");
        double firstOperand = this.getOperand(false);
        System.out.print("Arithmetic operator (+ - / *): ");
        Operator operator = this.getOperator();
        System.out.print("Second operand: ");
        double secondOperand = this.getOperand(operator.equals(Operator.DIVIDE));
        System.out.println("Result: " + this.getResult(firstOperand, operator, secondOperand));
    }

    double getOperand(boolean zeroIsInvalid) {
        double operand;
        while (true) {
            String input = scanner.nextLine();
            try {
                operand = Double.parseDouble(input);
                if (zeroIsInvalid && operand == 0.0) {
                    throw new ArithmeticException();
                }
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Please provide a valid number");
            } catch (ArithmeticException exception) {
                System.out.println("Please provide a valid number. It is impossible to divide by zero");
            }
        }
        return operand;
    }

    Operator getOperator() {
        Operator operator;
        while (true) {
            String input = scanner.nextLine();
            try {
                operator = this.parseOperator(input);
                break;
            } catch (InputMismatchException exception) {
                System.out.println("Please provide a valid operator '+ - * /'");
            }
        }
        return operator;
    }

    Operator parseOperator(String input) throws InputMismatchException {
        return switch (input) {
            case "+" -> Operator.ADD;
            case "-" -> Operator.SUBTRACT;
            case "*" -> Operator.MULTIPLY;
            case "/" -> Operator.DIVIDE;
            default -> throw new InputMismatchException();
        };
    }

    double getResult(double firstOperand, Operator operator, double secondOperator) {
        return switch (operator) {
            case ADD -> firstOperand + secondOperator;
            case SUBTRACT -> firstOperand - secondOperator;
            case MULTIPLY -> firstOperand * secondOperator;
            case DIVIDE -> firstOperand / secondOperator;
        };
    }
}

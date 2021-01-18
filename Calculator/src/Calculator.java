import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        //Declaring and initializing variables and scanner.
        double firstOperand;
        double secondOperand;
        double result = 0;
        int operation;
        Scanner scanner = new Scanner(System.in);

        //Prompt user for operands and input operands.
        System.out.println("Enter first operand: ");
        firstOperand = scanner.nextDouble();

        System.out.println("Enter second operand: ");
        secondOperand = scanner.nextDouble();

        //Print out calculator menu.
        System.out.println("Calculator Menu");
        System.out.println("---------------");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        //Prompt user for operation and input operation.
        System.out.println("Which operation do you want to perform?");
        operation = scanner.nextInt();

        //If user attempts division by 0 or enters operation other than 1,2,3,4, print error. Otherwise, perform calculation and print result.
        if ((operation == 4 && secondOperand == 0) || (operation != 1 && operation != 2 && operation != 3 && operation != 4)) {
            System.out.println("Error: Invalid selection! Terminating program.");
        } else {
            if (operation == 1) {
                result = firstOperand + secondOperand;
            } else if (operation == 2) {
                result = firstOperand - secondOperand;
            } else if (operation == 3) {
                result = firstOperand * secondOperand;
            } else if (operation == 4) {
                result = firstOperand / secondOperand;
            }
            System.out.println("The result of the operation is " + result + ". Goodbye! ");
        }
    }
}


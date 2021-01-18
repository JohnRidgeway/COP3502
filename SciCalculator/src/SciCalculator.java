import java.util.Scanner;

public class SciCalculator {

    //Create method that prints menu and asks for selection.
    public static void printMenu() {
        System.out.print("\nCalculator Menu\n---------------\n0. Exit Program\n1. Addition\n" +
                            "2. Subtraction\n3. Multiplication\n4. Division\n5. Exponentiation\n" +
                            "6. Logarithm\n7. Display Average\n\nEnter Menu Selection: ");
    }

    public static void main(String[] args) {
        //Initialize and create variables.
        double currentResult = 0.0;
        int menuOption;
        double firstOperand;
        double secondOperand;
        int calc = 0;
        int numCalculations = 0;
        double sumCalculations = 0;
        Scanner scnr = new Scanner(System.in);

        //Print first current result and menu.
        System.out.println("Current Result: " + currentResult);
        printMenu();

        //While variable calc is 0, the statement will loop.
        while (calc == 0) {
            //Take input from user for menu option.
            menuOption = scnr.nextInt();

            //If 0, thank user, chang calc to 1 and continue program, exiting while loop.
            if (menuOption == 0) {
                System.out.println("Thanks for using this calculator. Goodbye!");
                calc = 1;
                continue;
            }

            //If 7, print statistics or error and continue.
            else if (menuOption == 7) {
                if (numCalculations == 0) {
                    System.out.println("\nError: No calculations yet to average!\n\nEnter Menu Selection: ");
                    continue;
                }
                else {
                    System.out.println("Sum of calculations: " + sumCalculations);
                    System.out.println("Number of calculations: " + numCalculations);

                    if (sumCalculations < 0) {
                        System.out.println("Average of calculations: " + Math.round((-1 * sumCalculations / numCalculations) * 100) / -100.0 +
                                "\nEnter Menu Selection: ");
                    }
                    else {
                        System.out.println("Average of calculations: " + Math.round((sumCalculations / numCalculations) * 100) / 100.0 +
                                "\nEnter Menu Selection: ");
                    }
                    continue;
                }

            }

            //If menu is 1 - 6, get operands.
            else if (menuOption == 1 || menuOption == 2 || menuOption == 3 || menuOption == 4 || menuOption == 5 || menuOption == 6){
                System.out.println("Enter first operand: ");
                System.out.println("Enter second operand: ");
                firstOperand = scnr.nextDouble();
                secondOperand = scnr.nextDouble();

                //Perform corresponding operation to each choice and save output in currentResult.
                if (menuOption == 1) {
                    currentResult = firstOperand + secondOperand;
                }
                else if (menuOption == 2) {
                    currentResult = firstOperand - secondOperand;
                }
                else if (menuOption == 3) {
                    currentResult = firstOperand * secondOperand;
                }
                else if (menuOption == 4) {
                    currentResult = firstOperand / secondOperand;
                }
                else if (menuOption == 5) {
                    currentResult = Math.pow(firstOperand, secondOperand);
                }
                else if (menuOption == 6) {
                    currentResult = Math.log(secondOperand) / Math.log(firstOperand);
                }

                //Print current result and menu.
                System.out.println("Current Result: " + currentResult);
                    printMenu();
            }

            //If something other than the integers from 0-7 are inputted, print error and continue.
            else {
                System.out.println("Error: Invalid selection!\nEnter Menu Selection: ");
                continue;
            }

            //Increment the number of calculations and keep track of the sum of all the calculations.
            numCalculations = numCalculations + 1;
            sumCalculations = sumCalculations + currentResult;


        }
    }
}



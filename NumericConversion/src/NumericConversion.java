import java.util.Scanner;

public class NumericConversion {

    //Prints decoding menu.
    public static void printMenu() {
        System.out.println("Decoding Menu\n-------------\n1. Decode hexadecimal\n" +
                "2. Decode binary\n3. Convert binary to hexadecimal\n4. Quit\n\nPlease enter an option:\n");
    }

    //Reads each character in hexadecimal and converts to decimal using hexCharDecode() method. Then, uses these outputs
    //to convert entire hexadecimal to decimal.
    public static long hexStringDecode(String hex) {
        short character1Val = 0;
        short character2Val = 0;
        short character3Val = 0;
        short character4Val = 0;
        short character5Val = 0;
        short character6Val = 0;
        short character7Val = 0;
        short character8Val = 0;
        int length = hex.length();

        if (length > 0) {
            char character1 = hex.charAt(length - 1);
            character1Val = hexCharDecode(character1);
        }
        if (length > 1) {
            char character2 = hex.charAt(length - 2);
            character2Val = hexCharDecode(character2);
        }
        if (length > 2) {
            char character3 = hex.charAt(length - 3);
            character3Val = hexCharDecode(character3);
        }
        if (length > 3) {
            char character4 = hex.charAt(length - 4);
            character4Val = hexCharDecode(character4);
        }
        if (length > 4) {
            char character5 = hex.charAt(length - 5);
            character5Val = hexCharDecode(character5);
        }
        if (length > 5) {
            char character6 = hex.charAt(length - 6);
            character6Val = hexCharDecode(character6);
        }
        if (length > 6) {
            char character7 = hex.charAt(length - 7);
            character7Val = hexCharDecode(character7);
        }
        if (length > 7) {
            char character8 = hex.charAt(length - 8);
            character8Val = hexCharDecode(character8);
        }



        long decimalForm = (long) character1Val + (long) character2Val * 16 + (long) character3Val * 16 * 16 +
                (long) character4Val * 16 * 16 * 16 + (long) character5Val * 16 * 16 * 16 * 16 + (long) character6Val * 16 * 16 * 16 * 16 * 16 +
                (long) character7Val * 16 * 16 * 16 * 16 * 16 * 16 + (long) character8Val * 16 * 16 * 16 * 16 * 16 * 16 * 16;


        return  decimalForm;


    }

    //Converts digit in hexadecimal to its unicode and then to decimal, for both lower and upper case letters,
    //returning 0 for non hexadecimal characters.
    public static short hexCharDecode(char digit) {
        int val = digit;
        short decimal;
        switch (val) {
            case 49:
                decimal = 1;
                break;
            case 50:
                decimal = 2;
                break;
            case 51:
                decimal = 3;
                break;
            case 52:
                decimal = 4;
                break;
            case 53:
                decimal = 5;
                break;
            case 54:
                decimal = 6;
                break;
            case 55:
                decimal = 7;
                break;
            case 56:
                decimal = 8;
                break;
            case 57:
                decimal = 9;
                break;
            case 65:
            case 97:
                decimal = 10;
                break;
            case 66:
            case 98:
                decimal = 11;
                break;
            case 67:
            case 99:
                decimal = 12;
                break;
            case 68:
            case 100:
                decimal = 13;
                break;
            case 69:
            case 101:
                decimal = 14;
                break;
            case 70:
            case 102:
                decimal = 15;
                break;
            default:
                decimal = 0;
        }
        return decimal;
    }

    //Changes binary characters to their corresponding value, putting everything but 1 to 0.
    public static short binaryCharDecode(char binary) {
        int val = (int) binary;
        short decimal;
        switch (val) {
            case 48:
                decimal = 0;
                break;
            case 49:
                decimal = 1;
                break;
            default:
                decimal = 0;
                break;
        }
        return decimal;
    }

    //Uses binaryCharDecode to convert a binary string to its decimal form.
    public static short binaryStringDecode(String binary) {
        short val1 = 0;
        short val2 = 0;
        short val3 = 0;
        short val4 = 0;
        short val5 = 0;
        short val6 = 0;
        short val7 = 0;
        short val8 = 0;
        short val9 = 0;
        short val10 = 0;
        short val11 = 0;
        short val12 = 0;

        if (binary.length() > 0) {
            char character1 = binary.charAt(binary.length() - 1);
            val1 = binaryCharDecode(character1);
        }
        if (binary.length() > 1) {
            char character2 = binary.charAt(binary.length() - 2);
            val2 = binaryCharDecode(character2);
        }
        if (binary.length() > 2) {
            char character3 = binary.charAt(binary.length() - 3);
             val3 = binaryCharDecode(character3);
        }
        if (binary.length() > 3) {
            char character4 = binary.charAt(binary.length() - 4);
            val4 = binaryCharDecode(character4);
        }
        if (binary.length() > 4) {
            char character5 = binary.charAt(binary.length() - 5);
            val5 = binaryCharDecode(character5);
        }
        if (binary.length() > 5) {
            char character6 = binary.charAt(binary.length() - 6);
            val6 = binaryCharDecode(character6);
        }
        if (binary.length() > 6) {
            char character7 = binary.charAt(binary.length() - 7);
            val7 = binaryCharDecode(character7);
        }
        if (binary.length() > 7) {
            char character8 = binary.charAt(binary.length() - 8);
            val8 = binaryCharDecode(character8);
        }
        if (binary.length() > 8) {
            char character9 = binary.charAt(binary.length() - 9);
            val9 = binaryCharDecode(character9);
        }
        if (binary.length() > 9) {
            char character10 = binary.charAt(binary.length() - 10);
            val10 = binaryCharDecode(character10);
        }
        if (binary.length() > 10) {
            char character11 = binary.charAt(binary.length() - 11);
            val11 = binaryCharDecode(character11);
        }
        if (binary.length() > 11) {
            char character12 = binary.charAt(binary.length() - 12);
            val12 = binaryCharDecode(character12);
        }

        short decimalForm = (short) (val1 + val2 * 2 + val3 * 2 * 2 + val4 * 2 * 2 * 2 + val5 * 2 * 2 * 2 * 2 +
                        val6 * 2 * 2 * 2 * 2 * 2 + val7 * 2 * 2 * 2 * 2 * 2 * 2 + val8 * 2 * 2 * 2 * 2 * 2 * 2 * 2
                        + val9 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2  + val10 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2
                        + val11 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 + val12 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2);
        return decimalForm;

    }


    //Takes a binary string, decodes it to decimal using binaryStringDecode and then converts that to hexadecimal.
    public static String binaryToHex(String binary) {
        short decimalForm = binaryStringDecode(binary);
        int quotient = (int) decimalForm;
        String finalResult = "";
        int remainder;

        while (quotient != 0) {
            remainder = quotient % 16;
            quotient = quotient / 16;
            switch (remainder) {
                case 0:
                    finalResult = "0" + finalResult;
                    break;
                case 1:
                    finalResult = "1" + finalResult;
                    break;
                case 2:
                    finalResult = "2" + finalResult;
                    break;
                case 3:
                    finalResult = "3" + finalResult;
                    break;
                case 4:
                    finalResult = "4" + finalResult;
                    break;
                case 5:
                    finalResult = "5" + finalResult;
                    break;
                case 6:
                    finalResult = "6" + finalResult;
                    break;
                case 7:
                    finalResult = "7" + finalResult;
                    break;
                case 8:
                    finalResult = "8" + finalResult;
                    break;
                case 9:
                    finalResult = "9" + finalResult;
                    break;
                case 10:
                    finalResult = "A" + finalResult;
                    break;
                case 11:
                    finalResult = "B" + finalResult;
                    break;
                case 12:
                    finalResult = "C" + finalResult;
                    break;
                case 13:
                    finalResult = "D" + finalResult;
                    break;
                case 14:
                    finalResult = "E" + finalResult;
                    break;
                case 15:
                    finalResult = "F" + finalResult;
                    break;
                default:
                    break;
            }

        }
        return finalResult;
    }


    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        int menuOption = 0;
        boolean calc = true;

        while (calc) {
            //Prompt user for and take as input menu option.
            printMenu();
            menuOption = scnr.nextInt();

            //If menuOption is 1, converts hexadecimal to decimal.
            if (menuOption == 1) {
                System.out.println("Please enter the numeric string to convert: ");
                String input = scnr.next();
                System.out.println("Result: " + hexStringDecode(input));

            }
            //If menuOption is 2, converts binary to decimal.
            if (menuOption == 2) {
                System.out.println("Please enter the numeric string to convert: ");
                String input = scnr.next();
                System.out.println("Result: " + binaryStringDecode(input));
            }
            //If menuOption is 3, converts binary to hexadecimal.
            if (menuOption == 3) {
                System.out.println("Please enter the numeric string to convert: ");
                String input = scnr.next();
                System.out.println("Result: " + binaryToHex(input));
            }
            //If menuOption is 4, says goodbye and exits program.
            if (menuOption == 4) {
                calc = false;
                System.out.println("Goodbye!");
            }
        }

    }
}

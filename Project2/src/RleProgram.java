import java.io.Console;
import java.util.*;
import java.lang.reflect.Array;


public class RleProgram {

    //Method #1
    //Takes in byte array and returns string with decimal converted to hexadecimal.
    public static String toHexString(byte[] data) {

        String output = "";

        for (int i = 0; i < data.length; i = i + 1) {
            int entry = Array.getByte(data, i);
            String character;

            switch (entry) {
                case 0:
                    character = "0";
                    break;
                case 1:
                    character = "1";
                    break;
                case 2:
                    character = "2";
                    break;
                case 3:
                    character = "3";
                    break;
                case 4:
                    character = "4";
                    break;
                case 5:
                    character = "5";
                    break;
                case 6:
                    character = "6";
                    break;
                case 7:
                    character = "7";
                    break;
                case 8:
                    character = "8";
                    break;
                case 9:
                    character = "9";
                    break;
                case 10:
                    character = "a";
                    break;
                case 11:
                    character = "b";
                    break;
                case 12:
                    character = "c";
                    break;
                case 13:
                    character = "d";
                    break;
                case 14:
                    character = "e";
                    break;
                case 15:
                    character = "f";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + entry);
            }
            output = output + character;

        }
        return output;
    }


    //Method #2
    //Counts number of "runs" of each element in the data set.
    public static int countRuns(byte[] flatData){
        int numRuns = 1;
        int count = 1;
        for (int i = 0; i < (flatData.length - 1); i = i + 1) {
            if (flatData[i] == flatData[i + 1]) {
                count = count + 1;
            }
            else {
                numRuns = numRuns + 1;
                count = 1;
            }
            if (count >= 15) {
                numRuns = numRuns + 1;
                count = 1;
            }

        }

        return numRuns;
    }




    //Method #3
    //Create array with twice as many elements as number of runs in flatData,
    //stores number of elements in each run and the element in each run in that array
    //and returns it.
    public static byte[] encodeRle(byte[] flatData){

        boolean singleLastDigit = false;

        if (flatData[(flatData.length - 2)] != flatData[(flatData.length - 1)]){
            flatData = Arrays.copyOf(flatData, (flatData.length + 1));
            flatData[(flatData.length - 1)] = flatData[(flatData.length - 2)];
            singleLastDigit = true;
        }

        int numRuns = countRuns(flatData);
        byte[] encodedRle = new byte[(numRuns * 2)];

        byte count = 0;
        byte number;
        int i = 0;

        for (int j = 0; j < (numRuns); j = j + 1) {
            do {
                count = (byte) (count + 1);
                number = flatData[i];
                i = i + 1;
                if (count > 14){
                    break;
                }
            } while ((flatData[i - 1] == flatData[i]) && (i < (flatData.length - 1)));
            if ((i == (flatData.length - 1)) && (flatData[i - 1] == flatData[i])) {
                count = (byte) (count + 1);
            }

            encodedRle[(2 * j)] = count;
            encodedRle[(2 * j + 1)] = number;
            count = 0;
        }
        if (singleLastDigit) {
            encodedRle[(encodedRle.length - 2)] = (byte) (encodedRle[(encodedRle.length - 2)] - 1);
        }

        return encodedRle;

    }


    //Method #4
    //Counts number of entries in an RLE data set once converted to an image data set.
    public static int getDecodedLength(byte[] rleData) {
        int length = 0;
        for (int i = 0; i < (rleData.length / 2); i = i + 1) {
            length = length + rleData[(2 * i)];
        }
        return length;
    }



    //Method #5
    //Decodes RLE.
    public static byte[] decodeRle (byte[] rleData){
        byte[] decodedRle = new byte[0];

        int z = 0;
        for (int i = 0; i < (rleData.length / 2); i = i + 1) {
            int j = 0;
            decodedRle = Arrays.copyOf(decodedRle, decodedRle.length + rleData[(2 * i)]);
            while (j < rleData[(2 * i)]) {
                decodedRle[(z + j)] = rleData[(2 * i) + 1];
                j = j + 1;
            }
            z = z + j;
        }

        return decodedRle;
    }


    //Method #6
    //Translates a string of hexadecimal digits into their corresponding decimal
    //representation and puts those digits in a byte array.
    public static byte[] stringToData (String dataString) {
        int stringLength = dataString.length();
        byte[] data = new byte[stringLength];

        for (int i = 0; i < stringLength; i = i + 1){
            char character = dataString.charAt(i);
            switch (character){
                case '0':
                    data[i] = 0;
                    break;
                case '1':
                    data[i] = 1;
                    break;
                case '2':
                    data[i] = 2;
                    break;
                case '3':
                    data[i] = 3;
                    break;
                case '4':
                    data[i] = 4;
                    break;
                case '5':
                    data[i] = 5;
                    break;
                case '6':
                    data[i] = 6;
                    break;
                case '7':
                    data[i] = 7;
                    break;
                case '8':
                    data[i] = 8;
                    break;
                case '9':
                    data[i] = 9;
                    break;
                case 'a':
                    data[i] = 10;
                    break;
                case 'b':
                    data[i] = 11;
                    break;
                case 'c':
                    data[i] = 12;
                    break;
                case 'd':
                    data[i] = 13;
                    break;
                case 'e':
                    data[i] = 14;
                    break;
                case 'f':
                    data[i] = 15;
                    break;

            }
        }
        return data;
    }


    //Method #7
    //Translates odd indexed elements of rleData into hexadecimal and
    //creates string RLE data with colon seperation.
    public static String toRleString(byte[] rleData) {
        String[] hexInfo = new String[(rleData.length / 2)];
        String output = "";
        for (int i = 0; i < (rleData.length / 2); i = i + 1) {
            switch (rleData[(2 * i + 1)]){
                case 0:
                    hexInfo[i] = "0";
                    break;
                case 1:
                    hexInfo[i] = "1";
                    break;
                case 2:
                    hexInfo[i] = "2";
                    break;
                case 3:
                    hexInfo[i] = "3";
                    break;
                case 4:
                    hexInfo[i] = "4";
                    break;
                case 5:
                    hexInfo[i] = "5";
                    break;
                case 6:
                    hexInfo[i] = "6";
                    break;
                case 7:
                    hexInfo[i] = "7";
                    break;
                case 8:
                    hexInfo[i] = "8";
                    break;
                case 9:
                    hexInfo[i] = "9";
                    break;
                case 10:
                    hexInfo[i] = "a";
                    break;
                case 11:
                    hexInfo[i] = "b";
                    break;
                case 12:
                    hexInfo[i] = "c";
                    break;
                case 13:
                    hexInfo[i] = "d";
                    break;
                case 14:
                    hexInfo[i] = "e";
                    break;
                case 15:
                    hexInfo[i] = "f";
                    break;
            }
        }
        for (int i = 0; i < ((rleData.length / 2) - 1); i = i + 1) {
            output = output + rleData[(2 * i)] + hexInfo[i] + ":";
        }
        output = output + rleData[(rleData.length - 2)] + hexInfo[(hexInfo.length - 1)];
        return output;

    }


    //Method #8
    //Takes in string of RLE data in hexadecimal form and returns byte array in decimal form.
    public static byte[] stringToRle(String rleString) {

        byte[] byteForm = new byte[0];
        int i = 0;
        byte[] marker = new byte[1000];
        int m = 0;

        for (int j = 0; j < rleString.length(); j = j + 1) {
            String smallString = "";
            if (j < (rleString.length() - 3) && (rleString.charAt(j + 3) == ':')) {
                smallString = rleString.substring(j, j + 3);
                marker[m] = (byte) i;
                m = m + 1;
            } else if ((j < rleString.length() - 2) && (rleString.charAt(j + 2) == ':')) {
                smallString = rleString.substring(j, j + 2);
            } else {
                smallString = rleString.substring(j, j + 1);
            }

            if (smallString.length() == 4) {
                if (smallString.charAt(3) == ':') {
                    byteForm = Arrays.copyOf(byteForm, byteForm.length + 2);
                    int firstVal = smallString.charAt(1);
                    int secondVal = smallString.charAt(2);
                    switch (firstVal) {
                        case 48:
                            byteForm[i] = 10;
                            break;
                        case 49:
                            byteForm[i] = 11;
                            break;
                        case 50:
                            byteForm[i] = 12;
                            break;
                        case 51:
                            byteForm[i] = 13;
                            break;
                        case 52:
                            byteForm[i] = 14;
                            break;
                        case 53:
                            byteForm[i] = 15;
                            break;
                    }
                    switch (secondVal) {
                        case 48:
                            byteForm[(i + 1)] = 0;
                            break;
                        case 49:
                            byteForm[(i + 1)] = 1;
                            break;
                        case 50:
                            byteForm[(i + 1)] = 2;
                            break;
                        case 51:
                            byteForm[(i + 1)] = 3;
                            break;
                        case 52:
                            byteForm[(i + 1)] = 4;
                            break;
                        case 53:
                            byteForm[(i + 1)] = 5;
                            break;
                        case 54:
                            byteForm[(i + 1)] = 6;
                            break;
                        case 55:
                            byteForm[(i + 1)] = 7;
                            break;
                        case 56:
                            byteForm[(i + 1)] = 8;
                            break;
                        case 57:
                            byteForm[(i + 1)] = 9;
                            break;
                        case 97:
                            byteForm[(i + 1)] = 10;
                            break;
                        case 98:
                            byteForm[(i + 1)] = 11;
                            break;
                        case 99:
                            byteForm[(i + 1)] = 12;
                            break;
                        case 100:
                            byteForm[(i + 1)] = 13;
                            break;
                        case 101:
                            byteForm[(i + 1)] = 14;
                            break;
                        case 102:
                            byteForm[(i + 1)] = 15;
                            break;
                    }
                    j = j + 3;
                    i = i + 2;
                }
            }
            if (smallString.length() == 3) {
                if (smallString.charAt(2) == ':') {
                    byteForm = Arrays.copyOf(byteForm, byteForm.length + 2);
                    int firstVal = smallString.charAt(0);
                    int secondVal = smallString.charAt(1);
                    switch (firstVal) {
                        case 48:
                            byteForm[i] = 0;
                            break;
                        case 49:
                            byteForm[i] = 1;
                            break;
                        case 50:
                            byteForm[i] = 2;
                            break;
                        case 51:
                            byteForm[i] = 3;
                            break;
                        case 52:
                            byteForm[i] = 4;
                            break;
                        case 53:
                            byteForm[i] = 5;
                            break;
                        case 54:
                            byteForm[i] = 6;
                            break;
                        case 55:
                            byteForm[i] = 7;
                            break;
                        case 56:
                            byteForm[i] = 8;
                            break;
                        case 57:
                            byteForm[i] = 9;
                            break;
                        case 97:
                            byteForm[i] = 10;
                            break;
                        case 98:
                            byteForm[i] = 11;
                            break;
                        case 99:
                            byteForm[i] = 12;
                            break;
                        case 100:
                            byteForm[i] = 13;
                            break;
                        case 101:
                            byteForm[i] = 14;
                            break;
                        case 102:
                            byteForm[i] = 15;
                            break;
                    }
                    switch (secondVal) {
                        case 48:
                            byteForm[(i + 1)] = 0;
                            break;
                        case 49:
                            byteForm[(i + 1)] = 1;
                            break;
                        case 50:
                            byteForm[(i + 1)] = 2;
                            break;
                        case 51:
                            byteForm[(i + 1)] = 3;
                            break;
                        case 52:
                            byteForm[(i + 1)] = 4;
                            break;
                        case 53:
                            byteForm[(i + 1)] = 5;
                            break;
                        case 54:
                            byteForm[(i + 1)] = 6;
                            break;
                        case 55:
                            byteForm[(i + 1)] = 7;
                            break;
                        case 56:
                            byteForm[(i + 1)] = 8;
                            break;
                        case 57:
                            byteForm[(i + 1)] = 9;
                            break;
                        case 97:
                            byteForm[(i + 1)] = 10;
                            break;
                        case 98:
                            byteForm[(i + 1)] = 11;
                            break;
                        case 99:
                            byteForm[(i + 1)] = 12;
                            break;
                        case 100:
                            byteForm[(i + 1)] = 13;
                            break;
                        case 101:
                            byteForm[(i + 1)] = 14;
                            break;
                        case 102:
                            byteForm[(i + 1)] = 15;
                            break;
                    }
                    j = j + 2;
                    i = i + 2;
                }
            }
            if (smallString.length() == 2) {
                byteForm = Arrays.copyOf(byteForm, byteForm.length + 2);
                int firstVal = smallString.charAt(0);
                int secondVal = smallString.charAt(1);
                switch (firstVal) {
                    case 48:
                        byteForm[i] = 0;
                        break;
                    case 49:
                        byteForm[i] = 1;
                        break;
                    case 50:
                        byteForm[i] = 2;
                        break;
                    case 51:
                        byteForm[i] = 3;
                        break;
                    case 52:
                        byteForm[i] = 4;
                        break;
                    case 53:
                        byteForm[i] = 5;
                        break;
                    case 54:
                        byteForm[i] = 6;
                        break;
                    case 55:
                        byteForm[i] = 7;
                        break;
                    case 56:
                        byteForm[i] = 8;
                        break;
                    case 57:
                        byteForm[i] = 9;
                        break;
                    case 97:
                        byteForm[i] = 10;
                        break;
                    case 98:
                        byteForm[i] = 11;
                        break;
                    case 99:
                        byteForm[i] = 12;
                        break;
                    case 100:
                        byteForm[i] = 13;
                        break;
                    case 101:
                        byteForm[i] = 14;
                        break;
                    case 102:
                        byteForm[i] = 15;
                        break;
                }
                switch (secondVal) {
                    case 48:
                        byteForm[(i + 1)] = 0;
                        break;
                    case 49:
                        byteForm[(i + 1)] = 1;
                        break;
                    case 50:
                        byteForm[(i + 1)] = 2;
                        break;
                    case 51:
                        byteForm[(i + 1)] = 3;
                        break;
                    case 52:
                        byteForm[(i + 1)] = 4;
                        break;
                    case 53:
                        byteForm[(i + 1)] = 5;
                        break;
                    case 54:
                        byteForm[(i + 1)] = 6;
                        break;
                    case 55:
                        byteForm[(i + 1)] = 7;
                        break;
                    case 56:
                        byteForm[(i + 1)] = 8;
                        break;
                    case 57:
                        byteForm[(i + 1)] = 9;
                        break;
                    case 97:
                        byteForm[(i + 1)] = 10;
                        break;
                    case 98:
                        byteForm[(i + 1)] = 11;
                        break;
                    case 99:
                        byteForm[(i + 1)] = 12;
                        break;
                    case 100:
                        byteForm[(i + 1)] = 13;
                        break;
                    case 101:
                        byteForm[(i + 1)] = 14;
                        break;
                    case 102:
                        byteForm[(i + 1)] = 15;
                        break;
                }

                j = j + 2;
                i = i + 2;

            }

        }
        byteForm = Arrays.copyOf(byteForm, byteForm.length + 2);
        int firstVal = rleString.charAt(rleString.length() - 2);
        int secondVal = rleString.charAt(rleString.length() - 1);
        switch (firstVal) {
            case 48:
                byteForm[i] = 0;
                break;
            case 49:
                byteForm[i] = 1;
                break;
            case 50:
                byteForm[i] = 2;
                break;
            case 51:
                byteForm[i] = 3;
                break;
            case 52:
                byteForm[i] = 4;
                break;
            case 53:
                byteForm[i] = 5;
                break;
            case 54:
                byteForm[i] = 6;
                break;
            case 55:
                byteForm[i] = 7;
                break;
            case 56:
                byteForm[i] = 8;
                break;
            case 57:
                byteForm[i] = 9;
                break;
            case 97:
                byteForm[i] = 10;
                break;
            case 98:
                byteForm[i] = 11;
                break;
            case 99:
                byteForm[i] = 12;
                break;
            case 100:
                byteForm[i] = 13;
                break;
            case 101:
                byteForm[i] = 14;
                break;
            case 102:
                byteForm[i] = 15;
                break;
        }
        switch (secondVal) {
            case 48:
                byteForm[(i + 1)] = 0;
                break;
            case 49:
                byteForm[(i + 1)] = 1;
                break;
            case 50:
                byteForm[(i + 1)] = 2;
                break;
            case 51:
                byteForm[(i + 1)] = 3;
                break;
            case 52:
                byteForm[(i + 1)] = 4;
                break;
            case 53:
                byteForm[(i + 1)] = 5;
                break;
            case 54:
                byteForm[(i + 1)] = 6;
                break;
            case 55:
                byteForm[(i + 1)] = 7;
                break;
            case 56:
                byteForm[(i + 1)] = 8;
                break;
            case 57:
                byteForm[(i + 1)] = 9;
                break;
            case 97:
                byteForm[(i + 1)] = 10;
                break;
            case 98:
                byteForm[(i + 1)] = 11;
                break;
            case 99:
                byteForm[(i + 1)] = 12;
                break;
            case 100:
                byteForm[(i + 1)] = 13;
                break;
            case 101:
                byteForm[(i + 1)] = 14;
                break;
            case 102:
                byteForm[(i + 1)] = 15;
                break;
        }

        int placeHolder = byteForm[0];
        for (int k = 0; k < marker.length; k = k + 1) {
            byteForm[marker[k]] = (byte) (byteForm[marker[k]] + 10);
        }
        byteForm[0] = (byte) placeHolder;

        return byteForm;
    }





    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        String rleData = "";
        String rleDataDelimiter = "";
        String flatData = "";
        int option = 1;


        byte[] imageData = null;

        //Display welcome message
        System.out.println("Welcome to the RLE image encoder!\n");


        //Display color test with the message
        System.out.println("Displaying Spectrum Image:");
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow);

        while (option != 0) {
            //Display the menu and prompt user.
            System.out.println("\n\nRLE Menu\n--------\n0. Exit\n1. Load File\n2. Load Test Image\n3. Read RLE String\n" +
                    "4. Read RLE Hex String\n5. Read Data Hex String\n6. Display Image\n7. Display RLE String\n" +
                    "8. Display Hex RLE Data\n9. Display Hex Flat Data\n\nSelect a Menu Option: ");
            option = scnr.nextInt();

            if (option == 1) {
                System.out.println("Enter name of file to load: ");
                String fileName = scnr.next();
                imageData = ConsoleGfx.loadFile(fileName);
            }
            else if (option == 2) {
                System.out.println("Test image data loaded.");
                imageData = ConsoleGfx.loadFile("testfiles/gator.gfx");
            }

            //Prompts user and read RLE data in hexadecimal form with delimiter.
            else if (option == 3) {
                System.out.println("Enter an RLE string to be decoded: ");
                rleDataDelimiter = scnr.next();
            }

            //Prompts user and read RLE data in hexadecimal form without delimiter.
            else if (option == 4) {
                System.out.println("Enter the hex string holding RLE data: ");
                rleData = scnr.next();
            }

            //Prompts user and read flat data.
            else if (option == 5) {
                System.out.println("Enter the hex string holding flat data: ");
                flatData = scnr.next();
            }

            //Displays current image.
            else if (option == 6) {
                System.out.println("Displaying Image...");
                ConsoleGfx.displayImage(imageData);
            }

            //Displays RLE data without delimiters, with delimiters.
            else if (option == 7) {
                System.out.println("RLE representation: " + toRleString(stringToData(rleData)));
            }

            //Displays RLE data with delimiters, without delimiters.
            else if (option == 8) {
                System.out.println("RLE hex values: " + toRleString(stringToRle(rleDataDelimiter)));
            }

            else if (option == 9) {
                if (rleDataDelimiter.length() != 0) {
                    byte[] rleIntermediate = decodeRle(stringToRle(rleDataDelimiter));
                    flatData = "";
                    for (int i = 0; i < rleIntermediate.length; i = i + 1){
                        flatData = flatData + rleIntermediate[i];
                    }
                }
                System.out.println("Flat hex values: " + flatData);
            }


        }

    }
}

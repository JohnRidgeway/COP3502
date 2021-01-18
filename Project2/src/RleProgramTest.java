import jdk.nashorn.internal.objects.NativeString;

import java.lang.reflect.Array;
import java.util.*;

public class RleProgramTest {

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




    public static void main(String[] args){

        String rleString = "26:150:150:40:29";


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

        System.out.println(Arrays.toString(marker));
        System.out.println(Arrays.toString(byteForm));

    }




}

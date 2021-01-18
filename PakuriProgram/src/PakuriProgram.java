import java.util.*;

public class PakuriProgram {

    public static void printMenu() {
        System.out.println("Pakudex Main Menu   \n-----------------\n1. List Pakuri\n2. Show Pakuri\n3. Add Pakuri" +
                "\n4. Evolve Pakuri\n5. Sort Pakuri\n6. Exit\n\nWhat would you like to do?");
    }

    public static void main (String args[]) {
        Scanner scnr = new Scanner(System.in);
        String userInput;
        int capacityPakudex = -1;
        String tempInput = "0";
        int input = 0;
        boolean programRunning = true;
        String currentSpecies;


        //Welcomes user and takes in size, returning error if size is not possible
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        while (capacityPakudex == -1) {
            int count = 0;
            System.out.println("Enter max capacity of the Pakudex: ");
            userInput = scnr.next();
            for (int i = 0; i < userInput.length(); i = i + 1) {
                char holder = userInput.charAt(i);
                if (!Character.isDigit(holder)) {
                    System.out.println("Please enter a valid size.");
                    break;
                }
                else {
                    count = count + 1;
                }

            }
            if (count == userInput.length()) {
                capacityPakudex = Integer.parseInt(userInput);
            }

        }

        //Prints capcaity of Pakudex
        Pakudex dataPakudex = new Pakudex(capacityPakudex);
        System.out.println("The Pakudex can hold " + capacityPakudex + " species of Pakuri.\n");


        while (programRunning) {
            //Prints menu and takes input, printing error if not a valid option.
            printMenu();
            tempInput = scnr.next();
            boolean notInt = false;
            for (int i = 0; i < tempInput.length(); i = i + 1) {
                if (!Character.isDigit(tempInput.charAt(i))) {
                    notInt = true;
                }
            }

            //Convert input to integer
            if (notInt) {
                input = 0;
            }
            else {
                input = Integer.parseInt(tempInput);
            }


            //Returns list of Pakuri in Pakudex
            if (input == 1) {
                if (dataPakudex.getSize() == 0) {
                    System.out.println("No Pakuri in Pakudex yet!\n");
                }
                else {
                    System.out.println("Pakuri In Pakudex: ");
                    String array[] = dataPakudex.getSpeciesArray();
                    for (int i = 0; i < dataPakudex.getSize(); i = i + 1) {
                        System.out.println((i + 1) + ". " + array[i]);
                    }
                }
            }

            //Displays statistics of Pakudex entered.
            else if (input == 2) {
                System.out.println("Enter the name of the species to display: ");
                currentSpecies = scnr.next();
                int temp[] = dataPakudex.getStats(currentSpecies);
                System.out.println("Species: " + currentSpecies + "\nAttack: " + temp[0] + "\nDefense: " + temp[1] + "\nSpeed: " + temp[2] + "\n");
            }

            //Adds Pakuri to Pakudex, returns error if full or already exists
            else if (input == 3) {
                if (capacityPakudex == dataPakudex.getSize()){
                    System.out.println("Error: Pakudex is full!");
                }
                else {
                    System.out.println("Enter the name of the species to add: ");
                    currentSpecies = scnr.next();
                    dataPakudex.addPakuri(currentSpecies);
                }
            }

            //Evolves species entered, returns error if the species is not in the Pakudex
            else if (input == 4) {
                System.out.println("Enter the name of the species to evolve: ");
                currentSpecies = scnr.next();
                String[] array = dataPakudex.getSpeciesArray();
                boolean isIn = false;
                for (int i = 0; i < array.length; i = i + 1) {
                    if (array[i].equals(currentSpecies)) {
                        isIn = true;
                    }
                }
                if (isIn) {
                    dataPakudex.evolveSpecies(currentSpecies);
                    System.out.println(currentSpecies + " has evolved!");
                }
                else {
                    System.out.println("Error: No such Pakuri!");
                }
            }

            //Sorts Pakuri in Pakudex in lexicographical order
            else if (input == 5) {
                dataPakudex.sortPakuri();
                System.out.println("Pakuri have been sorted!");
            }

            //Ends program and prints goodbye message
            else if (input == 6) {
                 programRunning = false;
                 System.out.println("Thanks for using Pakudex! Bye!");
            }

            //Returns error for unrecognized menu selection
            else {
                System.out.println("Unrecognized menu selection!");
            }
        }

    }

}

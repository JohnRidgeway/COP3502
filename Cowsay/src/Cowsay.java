public class Cowsay {

    public static void main (String args[]) {
        Cow[] cow = new Cow[2];
        int count = args.length;

        //Based on value of first arguement, list cows and dragons, print selected cow or dragon, or print default
        if (args[0].equals("-1" ) || args[0].equals("-l" )) {
            listCows(cow);
        }
        else if (args[0].equals("-n")) {
            //If dragon is entered, finds on cow[] and converts to dragon.
            if (args[1].equals("dragon")) {
                Cow intermediateCow = findCow(args[1], cow);
                Dragon currentDragon = (Dragon) intermediateCow;
                if (currentDragon.getImage() == null) {
                    System.out.println("Could not find " + args[1] + " dragon!");
                }
                else {
                    for (int i = 2; i < count; i = i + 1) {
                        System.out.print(args[i] + " ");
                    }
                    System.out.println();
                    System.out.println(currentDragon.getImage());
                    System.out.println("This dragon can breathe fire.");
                }
            }
            //If icd-dragon is entered, finds on cow[] and converts to ice dragon.
            else if (args[1].equals("ice-dragon")) {
                Cow intermediateCow = findCow(args[1], cow);
                IceDragon currentDragon = (IceDragon) intermediateCow;
                if (currentDragon.getImage() == null) {
                    System.out.println("Could not find " + args[1] + " dragon!");
                }
                else {
                    for (int i = 2; i < count; i = i + 1) {
                        System.out.print(args[i] + " ");
                    }
                    System.out.println();
                    System.out.println(currentDragon.getImage());
                    System.out.println("This dragon cannot breathe fire.");
                }
            }
            else {
                Cow currentCow = findCow(args[1], cow);
                if (currentCow.getImage() == null) {
                    System.out.println("Could not find " + args[1] + " cow!");
                } else {
                    for (int i = 2; i < count; i = i + 1) {
                        System.out.print(args[i] + " ");
                    }
                    System.out.println();
                    System.out.println(currentCow.getImage());
                }
            }

        }
        else {
            Cow currentCow = findCow("heifer", cow);
            for (int i = 0; i < count; i = i + 1) {
                System.out.print(args[i] + " ");
            }
            System.out.println();
            System.out.println(currentCow.getImage());
        }


    }

    //Lists the cows available.
    private static void listCows (Cow[] cows) {
        cows = HeiferGenerator.getCows();

        System.out.print("Cows available:");
        for (int i = 0; i < cows.length; i = i + 1){
            Cow intermediate = new Cow(cows[i].getName());
            intermediate = cows[i];
            System.out.print(" " + intermediate.getName());
        }
    }

    //Takes in string of name and cow array and returns the cow object with the corresponding name.
    private static Cow findCow (String name, Cow[] cows) {
        cows = HeiferGenerator.getCows();
        String nameSelected;
        Cow returnVal = new Cow("cow");

        for (int i = 0; i < cows.length; i = i + 1){
            Cow intermediate = new Cow(cows[i].getName());
            intermediate = cows[i];
            nameSelected = intermediate.getName();
            if (nameSelected.equals(name)) {
                returnVal = intermediate;
            }
        }

        return returnVal;

    }
}


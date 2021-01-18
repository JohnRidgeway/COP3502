import java.util.*;

public class Pakudex {
    private int capacity;
    private Pakuri[] speciesArray = {};

    //Sets capacity to default of 20
    public Pakudex () {
        this.capacity = 20;
    }

    //Sets capacity to input
    public Pakudex (int capacity) {
        this.capacity = capacity;
    }

    //Returns size of Pakudex
    public int getSize () {
        int length = speciesArray.length;
        return length;
    }

    //Returns capacity of Pakudex
    public int getCapacity () {
        return this.capacity;
    }

    //Returns array of species names in Pakudex
    public String[] getSpeciesArray () {
        String result[] = new String[speciesArray.length];
        if (speciesArray.length == 0) {
            result = null;
        }
        else {
            for (int i = 0; i < speciesArray.length; i = i + 1) {
                result[i] = speciesArray[i].getSpecies();
            }
        }
        return result;
    }

    //Returns statistics of species in Pakudex
    public int[] getStats (String species) {
        int[] temp = new int[3];
        boolean success = false;
        String array[] = getSpeciesArray();
        for (int i = 0; i < speciesArray.length; i = i + 1){
            if (array[i].compareTo(species) == 0) {
                temp[0] = this.speciesArray[i].getAttack();
                temp[1] = this.speciesArray[i].getDefense();
                temp[2] = this.speciesArray[i].getSpeed();
                success = true;
            }
        }
        if (!success) {
            System.out.println("Error: No such Pakuri!\n");
            temp = null;
        }
        return temp;
    }

    //Sorts Pakudex in lexicographical order
    public void sortPakuri (){
        for (int i = 0; i < (speciesArray.length - 1); i = i + 1) {
            for(int j = 1 + i; j < speciesArray.length; j = j + 1) {
                if (speciesArray[i].getSpecies().compareTo(speciesArray[j].getSpecies()) > 0) {
                    Pakuri temp = speciesArray[i];
                    speciesArray[i] = speciesArray[j];
                    speciesArray[j] = temp;
                }
            }
        }
    }

    //Adds a Pakuri to Pakudex and returns true if successful
    public boolean addPakuri (String species) {
        boolean success = false;
        boolean alreadyThere = false;

        String array[] = getSpeciesArray();
        for (int i = 0; i < array.length; i = i + 1){
            if (array[i].compareTo(species) == 0) {
                alreadyThere = true;
            }
        }
        if (alreadyThere) {
            System.out.println("Error: Pakudex already contains this species!");
        }
        else {
            if (speciesArray.length < this.capacity) {
                Pakuri intermediate = new Pakuri(species);
                this.speciesArray = Arrays.copyOf(this.speciesArray, speciesArray.length + 1);
                speciesArray[(speciesArray.length - 1)] = intermediate;
                success = true;
                System.out.println("Pakuri species " + species + " successfully added!");

            } else {
                success = false;
                System.out.println("Error: Pakudex is full!");
            }
        }



        return success;
    }

    //Evolves species in Pakudex
    public boolean evolveSpecies (String species) {
        //Pakuri intermediate = new Pakuri(species);
        boolean val = false;
        for (int i = 0; i < speciesArray.length; i = i +1){
            if (speciesArray[i].getSpecies().equals(species)) {
                this.speciesArray[i].evolve();
                val = true;
            }
            else {
                val = false;
            }
        }
        return val;
    }



}

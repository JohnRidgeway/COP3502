import java.util.*;

public class Test {
    public static void main(String args[]) {
        String speciesArray[] = {"Hello", "Ja", "Kon", "Lop", "Re"};
        int capacity = 6;
        String species = "hello";

        boolean success;
        if (speciesArray.length < capacity) {
            speciesArray = Arrays.copyOf(speciesArray, speciesArray.length + 1);
            speciesArray[(speciesArray.length - 1)] = species;
            success = true;
        } else {
            success = false;
        }
        System.out.println(success);
        System.out.println(Arrays.toString(speciesArray));

    }
}

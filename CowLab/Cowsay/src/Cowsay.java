public class Cowsay {

    public static void main (String args[]) {
        Cow[] cowObj = new Cow[]



        //if (args[0] == -1) {
            for (int i = 0; i < Cow.length; i = i + 1) {
                System.out.println(cowObj[i].getName());
            }
        //}

    }
}


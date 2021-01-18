import java.util.Scanner;

    public class Hello {
        public static void main(String[] args){
            Scanner scnr = new Scanner(System.in);

            //Greet user, ask their name, and take it as input.
            System.out.print("Hello. What is your name?");
            String name = scnr.next();

            //Ask user's age and take as input.
            System.out.print("It's nice to meet you, " + name + ". How old are you?");
            String age = scnr.next();

            //Ask user where they live and take as input
            System.out.print("I see that you are still quite young at only " +  age + ".");
            System.out.print("Where do you live?");
            String home = scnr.next();

            //Say goodbye to user.
            System.out.print("Wow! I've always wanted to go to " +  home + ". Thanks for chatting with me. Bye! ");

        }
    }



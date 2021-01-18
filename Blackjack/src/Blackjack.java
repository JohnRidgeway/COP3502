
import java.util.Scanner;

public class Blackjack {

    //Create method that prints menu.
    public static void printMenu() {
        System.out.println("\n1. Get another card\n2. Hold hand\n3. Print statistics\n4. Exit\n\nChoose an option:");
    }

    //Create method that prints game stats so far.
    public static void printStats(int numPlayerWins, int numDealerWins, int numTies, int numGames){
        System.out.println("Number of Player wins: " + numPlayerWins);
        System.out.println("Number of Dealer wins: " + numDealerWins);
        System.out.println("Number of tie games: " + numTies);
        System.out.println("Total # of games played is: " + (numGames - 1));
        //Converts numPlayerWins from int to double and assigns value to numPlayerWin.
        double numPlayerWin = numPlayerWins;
        System.out.println("Percentage of Player wins: " + (numPlayerWin / (numGames - 1)) * 100 + "%");
    }

    public static void main(String[] args) {
        //Initialize and declare variables and import scanner and random number generator.
        int numGames = 1;
        int numPlayerWins = 0;
        int numDealerWins = 0;
        int numTies = 0;
        int option = 1;
        int myNumber;
        int playersHand = 0;
        int dealersHand = 0;
        int game = 0;
        P1Random rng = new P1Random();
        Scanner scnr = new Scanner(System.in);


        while (option != 4) {
            //Set dummy variable game to 0 which will be turned to 1 if a game is over so program begins.
            game = 0;

            //Prints start message, and draws first card.
            System.out.println("START GAME #" + numGames);
            myNumber = rng.nextInt(13) + 1;
            switch (myNumber) {
                case 1:
                    System.out.println("\nYour card is a ACE!");
                    playersHand = 1;
                    break;
                case 11:
                    System.out.println("\nYour card is a JACK!");
                    playersHand = 10;
                    break;
                case 12:
                    System.out.println("\nYour card is a QUEEN!");
                    playersHand = 10;
                    break;
                case 13:
                    System.out.println("\nYour card is a KING!");
                    playersHand = 10;
                    break;
                default:
                    System.out.println("\nYour card is a " + myNumber + "!");
                    playersHand = myNumber;
            }
            System.out.println("Your hand is: " + playersHand);

            while (game == 0) {
                //Print options and take input.
                printMenu();
                option = scnr.nextInt();

                //If player wants a card, deals card and prints out hand. If player wins or loses, prints message.
                if (option == 1) {
                    myNumber = rng.nextInt(13) + 1;
                    switch (myNumber) {
                        case 1:
                            System.out.println("Your card is a ACE!");
                            playersHand = playersHand + 1;
                            break;
                        case 11:
                            System.out.println("Your card is a JACK!");
                            playersHand = playersHand + 10;
                            break;
                        case 12:
                            System.out.println("Your card is a QUEEN!");
                            playersHand = playersHand + 10;
                            break;
                        case 13:
                            System.out.println("Your card is a KING!");
                            playersHand = playersHand + 10;
                            break;
                        default:
                            System.out.println("Your card is a " + myNumber + "!");
                            playersHand = playersHand + myNumber;
                    }
                    System.out.println("Your hand is: " + playersHand);
                    if (playersHand == 21) {
                        System.out.println("BLACKJACK! You win!");
                        game = 1;
                        numPlayerWins = numPlayerWins + 1;
                    }
                    else if (playersHand > 21) {
                        System.out.println("You exceeded 21! You lose.");
                        game = 1;
                        numDealerWins = numDealerWins + 1;
                    }
                }

                //If player holds, draws dealer's hand and displays outcome.
                if (option == 2) {
                    dealersHand = rng.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealersHand);
                    System.out.println("Your hand is: " + playersHand);
                    if ((dealersHand > 21) || (playersHand > dealersHand)) {
                        System.out.println("You win!");
                        numPlayerWins = numPlayerWins + 1;
                        game = 1;
                    } else if (dealersHand > playersHand) {
                        System.out.println("Dealer wins!");
                        numDealerWins = numDealerWins + 1;
                        game = 1;
                    } else if (dealersHand == playersHand) {
                        System.out.println("It's a tie! No one wins!");
                        numTies = numTies + 1;
                        game = 1;
                    }
                }

                //Uses printStats method to print statistics.
                if (option == 3) {
                    printStats(numPlayerWins, numDealerWins, numTies, numGames);
                }

                //Displays error message if invalid input.
                if (option != 1 && option != 2 && option != 3 && option != 4) {
                    System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                }

                //Exits game.
                if (option == 4) {
                    game = 1;
                    option = 4;
                }
            }

            //Increments game count.
            numGames = numGames + 1;
        }

        }




    }





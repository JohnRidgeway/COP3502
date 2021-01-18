import java.util.*;

public class ConnectFour {

    //Prints current board.
    public static void printBoard (char[][] array) {
        for (int i = 0; i < array.length ;  i = i + 1){
            for(int j = 0; j < array[0].length; j = j + 1) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Initializes board.
    public static void initializeBoard (char[][] array) {
        for (int i = 0; i < array.length; i = i + 1){
            for(int j = 0; j < array[1].length; j = j + 1) {
                array[i][j] = '-';
            }
        }
    }

    //Places the token in the column that the user has chosen.
    public static int insertChip (char[][] array, int col, char chipType) {
        int row = 0;
        for (int i = 1; i < array.length; i = i + 1) {
            switch(array[i][col]){
                case('-'):
                    row = i;
                    break;
                default:
                    break;
            }
        }
        return row;
    }

    //Checks whether or not someone has won the game.
    public static boolean checkIfWinner (char[][] array, int col, int row, char chipType) {
        boolean win = false;
        //Checks column win.
        for (int i = 0; i < array.length - 3; i = i + 1){
            for (int j = 0; j < array[1].length; j = j + 1){
                if ((array[i][j] == chipType) && (array[i + 1][j] == chipType) && (array[i + 2][j] == chipType) && (array[i + 3][j] == chipType)){
                    win = true;
                }
            }
        }

        //Checks row win.
        for (int i = 0; i < array.length; i = i + 1){
            for (int j = 0; j < array[1].length - 3; j = j + 1){
                if ((array[i][j] == chipType) && (array[i][j + 1] == chipType) && (array[i][j + 2] == chipType) && (array[i][j + 3] == chipType)){
                    win = true;
                }
            }
        }

        return win;
    }


    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);
        int height;
        int length;
        int player1Col;
        int player1Row;
        int player2Col;
        int player2Row;
        int numPlays = 0;
        boolean gameOver = false;

        //Prompt user and take in input of height and lenght of board.
        System.out.println("What would you like the height of the board to be? ");
        height = scnr.nextInt();
        System.out.println("What would you like the length of the board to be? ");
        length = scnr.nextInt();

        //Create board of desired dimensions, fill with dashes and display.
        char board[][] = new char[height][length];
        initializeBoard(board);
        printBoard(board);


        //Tell players their tokens
        System.out.println("\nPlayer 1: x\nPlayer 2: o");


        while (!gameOver) {
            //Play player 1's move.
            System.out.println("Player 1: Which column would you like to choose? ");
            player1Col = scnr.nextInt();
            player1Row = insertChip(board, player1Col, 'x');
            board[player1Row][player1Col] = 'x';
            printBoard(board);
            if (checkIfWinner(board, player1Col, player1Row, 'x')) {
                System.out.println("Player 1 won the game!");
                gameOver = true;
                break;
            }
            numPlays = numPlays + 1;

            //Play player 2's move.
            System.out.println("Player 2: Which column would you like to choose? ");
            player2Col = scnr.nextInt();
            player2Row = insertChip(board, player2Col, 'o');
            board[player2Row][player2Col] = 'o';
            printBoard(board);
            if (checkIfWinner(board, player2Col, player2Row, 'o')) {
                System.out.println("Player 2 won the game!");
                gameOver = true;
                break;
            }
            numPlays = numPlays + 1;

            if (numPlays == (height * length)) {
                System.out.println("Draw. Nobody wins.");
                gameOver = true;
                break;
            }
        }




    }

}

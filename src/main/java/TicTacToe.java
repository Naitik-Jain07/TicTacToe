import java.util.Random;

public class TicTacToe {

    static String player1 = "Player 1";
    static String player2 = "Player 2";

    static char player1Symbol;
    static char player2Symbol;
    static String currentPlayer;

    public static void main(String[] args) {

        // UC2: Toss to Decide First Player and Symbol
        Random random = new Random();

        int toss = random.nextInt(2); // 0 or 1

        if (toss == 0) {
            currentPlayer = player1;
            player1Symbol = 'X';
            player2Symbol = 'O';
        } else {
            currentPlayer = player2;
            player2Symbol = 'X';
            player1Symbol = 'O';
        }

        // Display Results
        System.out.println("=== Toss Result ===");
        System.out.println(currentPlayer + " won the toss!");
        System.out.println(player1 + " Symbol: " + player1Symbol);
        System.out.println(player2 + " Symbol: " + player2Symbol);
        System.out.println(currentPlayer + " will play first.");
    }
}
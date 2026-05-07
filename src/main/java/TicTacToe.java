import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static String player1 = "Player 1";
    static String player2 = "Player 2";

    static char player1Symbol;
    static char player2Symbol;
    static String currentPlayer;

    static Scanner scanner = new Scanner(System.in);

    // UC3: Accept User Slot Input
    public static int getUserSlot() {
        System.out.print("Enter a slot number (1-9): ");
        return scanner.nextInt();
    }

    // UC4: Convert Slot Number to Row and Column
    public static int[] convertSlotToIndex(int slot) {

        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        return new int[]{row, col};
    }

    public static void main(String[] args) {

        // UC2: Toss to Decide First Player and Symbol
        Random random = new Random();

        int toss = random.nextInt(2);

        if (toss == 0) {
            currentPlayer = player1;
            player1Symbol = 'X';
            player2Symbol = 'O';
        } else {
            currentPlayer = player2;
            player2Symbol = 'X';
            player1Symbol = 'O';
        }

        System.out.println("=== Toss Result ===");
        System.out.println(currentPlayer + " won the toss!");
        System.out.println(player1 + " Symbol: " + player1Symbol);
        System.out.println(player2 + " Symbol: " + player2Symbol);

        // UC3
        int userSlot = getUserSlot();

        // UC4
        int[] index = convertSlotToIndex(userSlot);

        System.out.println("Row Index: " + index[0]);
        System.out.println("Column Index: " + index[1]);
    }
}
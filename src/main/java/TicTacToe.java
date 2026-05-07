import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private char[][] board;
    private char currentPlayer;
    private Random random;

    public TicTacToe() {
        board = new char[3][3];
        random = new Random();
        currentPlayer = 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " +
                    board[i][1] + " | " +
                    board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
                col >= 0 && col < 3 &&
                board[row][col] == ' ';
    }

    public void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public boolean checkWin(char player) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;

            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void playerMove(Scanner sc) {

        int slot, row, col;

        do {
            System.out.println("Player " + currentPlayer + " enter slot (1-9): ");
            slot = sc.nextInt();

            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

        } while (!isValidMove(row, col));

        placeMove(row, col, currentPlayer);
    }

    public void computerMove() {

        int slot, row, col;

        do {
            slot = random.nextInt(9) + 1;

            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

        } while (!isValidMove(row, col));

        placeMove(row, col, 'O');
        System.out.println("Computer played slot: " + slot);
    }

    public void playGame() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            printBoard();

            if (currentPlayer == 'X') {
                playerMove(sc);
            } else {
                computerMove();
            }

            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isDraw()) {
                printBoard();
                System.out.println("Game Draw!");
                break;
            }

            switchPlayer();
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
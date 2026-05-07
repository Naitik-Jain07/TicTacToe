import java.util.Random;

public class TicTacToe {

    private char[][] board;
    private Random random;

    public TicTacToe() {
        board = new char[3][3];
        random = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row <= 2 &&
                col >= 0 && col <= 2 &&
                board[row][col] == ' ';
    }

    public void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public void computerMove() {
        int slot;
        int row, col;

        do {
            slot = random.nextInt(9) + 1;

            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

        } while (!isValidMove(row, col));

        placeMove(row, col, 'O');
        System.out.println("Computer placed at slot: " + slot);
    }
}
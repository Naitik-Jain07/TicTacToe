public class TicTacToe {

    private char[][] board;
    private char currentPlayer;

    // Constructor
    public TicTacToe() {
        board = new char[3][3];

        // initialize board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        currentPlayer = 'X';
    }

    // Display board
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " +
                    board[i][1] + " | " +
                    board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
    }

    // Switch player
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Make move (UC4 + UC5 combined)
    public boolean makeMove(int slot) {

        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        // UC5 validation
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != ' ') {
            return false;
        }

        // place move
        board[row][col] = currentPlayer;
        return true;
    }

    // Main game loop
    public void playGame() {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            printBoard();

            System.out.println("Player " + currentPlayer + " enter slot (1-9): ");
            int slot = sc.nextInt();

            if (makeMove(slot)) {
                switchPlayer();
            } else {
                System.out.println("Invalid move, try again.");
                i--; // repeat turn
            }
        }

        printBoard();
        System.out.println("Game Over!");
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
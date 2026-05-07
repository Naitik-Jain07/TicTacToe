public class TicTacToe {

    public boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner(char[][] board) {
        return false;
    }

    public boolean isDraw(char[][] board) {
        if (!hasWinner(board) && isBoardFull(board)) {
            return true;
        }
        return false;
    }
}
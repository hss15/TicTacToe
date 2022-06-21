import java.util.Arrays;

public class Board {
    int n;
    char[][] board;
    int[] row;
    int[] col;
    int lDiag; // top-right to bottom-left
    int rDiag; // top-left to bottom-right
    int filled;

    public Board(int n) {
        this.n = n;
        this.board = new char[n][n];
        for (char[] row : this.board) {
            Arrays.fill(row, '.');
        }
        this.row = new int[n];
        this.col = new int[n];
        this.lDiag = 0;
        this.rDiag = 0;
        this.filled = 0;
    }

    public boolean validMove(Move move) {
        return move.x >= 0 && move.y >= 0 && move.x < n && move.y < n && board[move.x][move.y] == '.';
    }

    public void makeMove(Move move, char ch) {
        board[move.x][move.y] = ch;
        filled++;

        int change = changeInVal(ch);
        row[move.x] += change;
        col[move.y] += change;

        if (move.x == move.y) {
            rDiag += change;
        }

        if (move.x + move.y == n - 1) {
            lDiag += change;
        }
    }

    public boolean winningMove(Move move) {
        return n == Math.abs(row[move.x]) || n == Math.abs(col[move.y]) || n == Math.abs(rDiag) || n == Math.abs(lDiag);
    }

    public boolean canPlay() {
        return filled < n * n;
    }

    private int changeInVal(char ch) {
        return ch == 'x' ? 1 : -1;
    }
}

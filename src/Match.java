import java.util.ArrayList;
import java.util.List;

public class Match {
    User player1;
    User player2;
    User winner;
    Board board;
    List<Move> moves;

    public Match(User player1, User player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.moves = new ArrayList<>();
        this.winner = null;
    }

    public User play() {
        User currPlayer = player1;
        while (board.canPlay()) {
            System.out.println(currPlayer.name + " Make move: ");

            Move move = currPlayer.makeMove();

            if (board.validMove(move)) {
                moves.add(move);

                board.makeMove(move, symbol(currPlayer));
                boolean win = board.winningMove(move);

                if (win) {
                    winner = currPlayer;
                    break;
                }
            } else {
                System.out.println("Invalid move");
                continue;
            }

            currPlayer = nextPlayer(currPlayer);
        }

        return winner;
    }

    public char symbol(User player) {
        return player == player1 ? 'x' : 'o';
    }

    public User nextPlayer(User currPlayer) {
        return currPlayer == player1 ? player2 : player1;
    }
}

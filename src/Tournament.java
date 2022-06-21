public class Tournament {
    public static void main(String[] args) {
        User p1 = new User("p1", "11111");
        User p2 = new User("p2", "22222");
        Board board = new Board(3);

        Match match = new Match(p1, p2, board);
        User winner = match.play();

        if (winner != null) {
            winner.increaseScore();

            System.out.println("The winner is " + winner.name);
        } else {
            System.out.println("Draw");
        }
    }
}

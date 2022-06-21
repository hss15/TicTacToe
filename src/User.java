import java.util.Scanner;

public class User {
    String name;
    String phoneNumber;
    int score;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.score = 0;
    }

    public Move makeMove() {
        Scanner obj = new Scanner(System.in);
        int x = obj.nextInt();
        int y = obj.nextInt();

        return new Move(x, y, this);
    }

    public void increaseScore() {
        this.score++;
    }
}

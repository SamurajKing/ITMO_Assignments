package hw10_mnk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int result = new TwoPlayerGame(
                new HexBoard(7, 3),
                new HumanPlayer(new Scanner(System.in)),
                new RandomPlayer(false)
        ).play(true);
        switch (result) {
            case 1:
                System.out.println("First player won");
                break;
            case 2:
                System.out.println("Second player won");
                break;
            case 0:
                System.out.println("Draw");
                break;
            default:
                throw new AssertionError("Unknown result " + result);
        }
    }
}

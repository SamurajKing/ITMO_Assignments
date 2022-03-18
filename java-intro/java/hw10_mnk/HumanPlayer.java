package hw10_mnk;

import java.util.Scanner;

import static hw10_mnk.Utilites.isNumber;

public class HumanPlayer implements Player {
    private final Scanner in;

    public HumanPlayer(Scanner in) {
        this.in = in;
    }

    Move getMove(PositionProxy position) {
        String line = in.nextLine();
        String[] elements = line.split(" +");
        while (!(elements.length == 2
                && isNumber(elements[0])
                && isNumber(elements[1])
                && position.isValid(new Move(
                            Integer.parseInt(elements[0]) - 1,
                            Integer.parseInt(elements[1]) - 1,
                            position.getTurn()))
                || (elements.length == 1 && (elements[0].equals("DRAW") || elements[0].equals("LOOSE"))
            ))) {
            System.out.println("Your move is incorrect! Please, do a correct move:");
            line = in.nextLine();
            elements = line.split(" +");
        }
        if (elements.length == 1 && elements[0].equals("DRAW")) {
            return new OfferDrawMove(0, 0, position.getTurn());
        } else if (elements.length == 1) {
            return new LooseMove(0, 0, position.getTurn());
        } else {
            return new Move(Integer.parseInt(elements[0]) - 1, Integer.parseInt(elements[1]) - 1, position.getTurn());
        }
    }

    @Override
    public Move makeMove(PositionProxy position) {
        System.out.println();
        System.out.println("Enter you move for " + position.getTurn());
        System.out.println("If you want to offer draw input DRAW");
        System.out.println("If you want to loose game input LOOSE");
        return getMove(position);
    }

    @Override
    public int handleDrawOffer() {
        System.out.println("Other player offered you a draw.\n Do you agree? (1 - yes, other number - no)");
        String line;
        line = in.nextLine();
        while (!isNumber(line)) {
            System.out.println("Your answer is incorrect! Please, do a correct move:");
            line = in.nextLine();
        }
        return Integer.parseInt(line);
    }
}

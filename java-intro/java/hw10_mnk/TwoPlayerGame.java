package hw10_mnk;

public class TwoPlayerGame {
    private final Board board;
    private final Player player1;
    private final Player player2;

    public TwoPlayerGame(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int play(boolean log) {
        while (true) {
            final int result1 = makeMove(player1, 1, log);
            if (result1 != -1 && result1 < 4)  {
                return result1;
            } else if (result1 == 4) {
                //offer draw
                int offerResult = player2.handleDrawOffer();
                if (offerResult == 1) {
                    return 0;
                } else {
                    System.out.println(board);
                    System.out.println("No! I don't want to DRAW.");
                }
            } else if (result1 == 5) {
                //loose game
                return 2;
            }
            final int result2 = makeMove(player2, 2, log);
            if (result2 != -1 && result2 < 4)  {
                return result2;
            } else if (result2 == 4) {
                //offer draw
                int offerResult = player1.handleDrawOffer();
                if (offerResult == 1) {
                    return 0;
                } else {
                    System.out.println(board);
                    System.out.println("No! I don't want to DRAW.");
                }
            } else if (result2 == 5) {
                //loose game
                return 1;
            }
        }
    }

    private int makeMove(Player player, int no, boolean log) {
        final Move move;
        try {
            move = player.makeMove(board.getPosition());
        } catch (Exception e) {
            return 3 - no;
        }
        if (move instanceof OfferDrawMove) {
            return 4;
        } else if (move instanceof LooseMove) {
            return 5;
        }
        final GameResult result = board.makeMove(move);
        if (log) {
            System.out.println();
            System.out.println("Player: " + no);
            System.out.println(move);
            System.out.println(board);
            System.out.println("Result: " + result);
        }
        switch (result) {
            case WIN:
                return no;
            case LOOSE:
                return 3 - no;
            case DRAW:
                return 0;
            case UNKNOWN:
                return -1;
            default:
                throw new AssertionError("Unknown makeMove result " + result);
        }
    }
}

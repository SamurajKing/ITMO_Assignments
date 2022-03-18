package hw10_mnk;

public class SequentialPlayer implements Player {
    private int parity = 0;
    @Override
    public Move makeMove(PositionProxy position) {
        for (int r = 0; r < position.getM(); r++) {
            for (int c = 0; c < position.getN(); c++) {
                final Move move = new Move(r, c, position.getTurn());
                if (position.isValid(move)) {
                    return move;
                }
            }
        }
        throw new AssertionError("No valid moves");
    }

    @Override
    public int handleDrawOffer() {
        return (parity++) % 2;
    }
}

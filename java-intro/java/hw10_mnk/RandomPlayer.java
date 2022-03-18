package hw10_mnk;

import java.util.Random;

public class RandomPlayer implements Player {
    private final Random random = new Random();
    private final boolean drawOffer;

    public RandomPlayer(boolean drawOffer) {
        this.drawOffer = drawOffer;
    }

    @Override
    public Move makeMove(PositionProxy position) {
        while (true) {
            final Move move = new Move(
                    random.nextInt(position.getM()),
                    random.nextInt(position.getN()),
                    position.getTurn()
            );
            int offerDraw = random.nextInt(3);
            if (offerDraw == 1 && this.drawOffer) {
                return new OfferDrawMove(0, 0, position.getTurn());
            }
            if (position.isValid(move)) {
                return move;
            }
        }
    }

    @Override
    public int handleDrawOffer() {
        return random.nextInt(2);
    }
}

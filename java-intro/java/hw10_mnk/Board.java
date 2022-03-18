package hw10_mnk;

public interface Board {
    PositionProxy getPosition();

    GameResult makeMove(Move move);
}

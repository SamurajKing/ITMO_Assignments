package hw10_mnk;

public interface Player {
    Move makeMove(PositionProxy position);
    int handleDrawOffer();
}

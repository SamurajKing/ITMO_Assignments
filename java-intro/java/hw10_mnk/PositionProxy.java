package hw10_mnk;

public class PositionProxy implements Position {
    private final Position position;

    public PositionProxy(Position position) {
        this.position = position;
    }

    @Override
    public Cell getTurn() {
        return position.getTurn();
    }

    @Override
    public boolean isValid(Move move) {
        return position.isValid(move);
    }

    @Override
    public int getM() {
        return position.getM();
    }

    @Override
    public int getN() {
        return position.getN();
    }

    @Override
    public Cell getCell(int row, int column) {
        return position.getCell(row, column);
    }
}

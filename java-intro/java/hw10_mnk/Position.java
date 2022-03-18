package hw10_mnk;

public interface Position {
    Cell getTurn();

    boolean isValid(Move move);

    int getM();
    int getN();

    Cell getCell(int row, int column);
}

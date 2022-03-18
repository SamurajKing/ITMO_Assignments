package hw10_mnk;

import java.util.Arrays;
import java.util.Map;

public class MNKBoard implements Board, Position {
    private static final Map<Cell, String> CELL_TO_STRING = Map.of(
            Cell.E, ".",
            Cell.X, "X",
            Cell.O, "0"
    );

    private final Cell[][] field;
    private int remainingCells;
    private Cell turn;
    private final int m;
    private final int n;
    private final int k;

    public MNKBoard(int m, int n, int k) {
        m = Math.max(0, m);
        n = Math.max(0, n);
        field = new Cell[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        remainingCells = m * n;
        turn = Cell.X;
    }

    @Override
    public PositionProxy getPosition() {
        return new PositionProxy(this);
    }

    @Override
    public GameResult makeMove(Move move) {
        if (!isValid(move)) {
            return GameResult.LOOSE;
        }

        field[move.getRow()][move.getCol()] = move.getValue();
        --remainingCells;
        if (checkWin(move.getRow(), move.getCol(), move.getValue())) {
            return GameResult.WIN;
        }

        if (checkDraw()) {
            return GameResult.DRAW;
        }

        turn = turn == Cell.X ? Cell.O : Cell.X;
        return GameResult.UNKNOWN;
    }

    private boolean checkDraw() {
        return remainingCells == 0;
    }

    public boolean goodCell(int i, int j) {
        return 0 <= i && 0 <= j && i < m && j < n;
    }

    private boolean checkWin(int r, int c, Cell placed) {
        int[] cnt = new int[4];

        int[] dx = {-1, -1, -1, 0};
        int[] dy = {-1, +1, 0, -1};

        int[] dx1 = {+1, +1, +1, 0};
        int[] dy1 = {+1, -1, 0, +1};

        int[] dr = {+1, +1, +1, 0};
        int[] dc = {+1, -1, 0, +1};

        int i, j;

        for (int it = 0; it < 4; ++it) {
            i = r;
            j = c;
            while (goodCell(i, j) && getCell(i, j) == placed && cnt[it] < k) {
                i += dx[it];
                j += dy[it];
                cnt[it]++;
            }
            i = r + dr[it];
            j = c + dc[it];
            while (goodCell(i, j) && getCell(i, j) == placed && cnt[it] < k) {
                i += dx1[it];
                j += dy1[it];
                cnt[it]++;
            }
        }

        return Math.max(Math.max(cnt[0], cnt[1]), Math.max(cnt[2], cnt[3])) >= k;
    }

    @Override
    public Cell getTurn() {
        return turn;
    }

    @Override
    public boolean isValid(Move move) {
        return 0 <= move.getRow() && move.getRow() < m
                && 0 <= move.getCol() && move.getCol() < n
                && field[move.getRow()][move.getCol()] == Cell.E
                && turn == move.getValue();
    }

    @Override
    public int getM() {
        return m;
    }

    @Override
    public int getN() {
        return n;
    }

    @Override
    public Cell getCell(int row, int column) {
        return field[row][column];
    }

    @Override
    public String toString() {
        final StringBuilder line = new StringBuilder(" ");
        for (int j = 0; j < n; ++j) {
            line.append(j + 1);
        }
        final StringBuilder sb = new StringBuilder(line).append(System.lineSeparator());
        for (int r = 0; r < m; r++) {
            sb.append(r + 1);
            for (Cell cell : field[r]) {
                sb.append(CELL_TO_STRING.get(cell));
            }
            sb.append(System.lineSeparator());
        }
        sb.setLength(sb.length() - System.lineSeparator().length());
        return sb.toString();
    }
}

/*
* int i = r, j = c;
        while (i >= 0 && j >= 0 && getCell(i, j) == placed && cnt[0] < k) {
            i--;
            j--;
            cnt[0]++;
        }
        i = r + 1;
        j = c + 1;
        while (i < m && j < n && getCell(i, j) == placed && cnt[0] < k) {
            i++;
            j++;
            cnt[0]++;
        }

        i = r;
        j = c;
        while (i >= 0 && j < n && getCell(i, j) == placed && cnt[1] < k) {
            i--;
            j++;
            cnt[1]++;
        }
        i = r + 1;
        j = c - 1;
        while (i < m && j >= 0 && getCell(i, j) == placed && cnt[1] < k) {
            i++;
            j--;
            cnt[1]++;
        }

        i = r;
        j = c;
        while (i >= 0 && getCell(i, j) == placed && cnt[2] < k) {
            i--;
            cnt[2]++;
        }
        i = r + 1;
        j = c;
        while (i < m && getCell(i, j) == placed && cnt[2] < k) {
            i++;
            cnt[2]++;
        }

        i = r;
        j = c;
        while (j >= 0 && getCell(i, j) == placed && cnt[3] < k) {
            j--;
            cnt[3]++;
        }
        i = r;
        j = c + 1;
        while (j < n && getCell(i, j) == placed && cnt[3] < k) {
            j++;
            cnt[3]++;
        }
* */

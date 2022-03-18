package hw10_mnk;

import java.util.Arrays;
import java.util.Map;

public class HexBoard implements Board, Position {
    private static final Map<Cell, String> CELL_TO_STRING = Map.of(
            Cell.E, ".",
            Cell.X, "X",
            Cell.O, "0"
    );

    private final Cell[][] field;
    private int remainingCells;
    private Cell turn;
    private final int m;
    private final int k;

    public HexBoard(int m, int k) {
        m = Math.max(0, m);
        field = new Cell[2 * (m + 1) + 1][2 * (m + 1) + 1];
        this.m = m * 2 - 1;
        this.k = k;
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        remainingCells = (this.m / 2 + 1) * (this.m / 2 + 2) - (this.m / 2 + 1); // TODO
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

        field[move.getRow() + 1][move.getCol() + 1] = move.getValue();
        --remainingCells;
        if (checkWin(move.getRow() + 1, move.getCol() + 1, move.getValue())) {
            return GameResult.WIN;
        }

        if (checkDraw()) {
            return GameResult.DRAW;
        }

        turn = turn == Cell.X ? Cell.O : Cell.X;
        return GameResult.UNKNOWN;
    }

    @Override
    public Cell getTurn() {
        return turn;
    }

    private boolean checkWin(int r, int c, Cell placed) {
        int[] cnt = new int[3];

        int[] dx = {-1, -2, 0};
        int[] dy = {+1, 0, -2};

        int[] dx1 = {+1, +2, 0};
        int[] dy1 = {-1, 0, +2};

        int[] dr = {+1, +2, 0};
        int[] dc = {-1, 0, +2};

        int i, j;

        for (int it = 0; it < 3; ++it) {
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

        return Math.max(Math.max(cnt[0], cnt[1]), cnt[2]) >= k;
    }


    private boolean checkDraw() {
        return remainingCells == 0;
    }

    public boolean goodCell(int r, int c) {
        boolean allFine = 1 <= r && r <= m;
        if (r > m / 2 + 1) {
            r = m / 2 + 1 - (r - (m / 2 + 1));
        }
        int L, R;
        int center;
        if (r % 2 == 1)  {
            L = (m / 2 + 1) - 2 * (r / 2);
            R = (m / 2 + 1) + 2 * (r / 2);
            center = m / 2 + 1;
        } else {
            L = (m / 2 + 1) - 1 - 2 * (r / 2 - 1);
            R = (m / 2 + 1) + 1 + 2 * (r / 2 - 1);
            center = m / 2;
        }
        R = Math.min(m, R);
        L = Math.max(1, L);
        allFine &= (L <= c && c <= R && c % 2 == center % 2);
        return allFine;
    }


    @Override
    public boolean isValid(Move move) {
        int r = move.getRow() + 1;
        int c = move.getCol() + 1;
        boolean allFine = goodCell(r, c);
        if (!allFine) {
            return false;
        }
        allFine = field[r][c] == Cell.E;
        allFine &= turn == move.getValue();
        return allFine;
    }

    @Override
    public int getM() {
        return m;
    }

    @Override
    public int getN() {
        return m;
    }

    @Override
    public Cell getCell(int row, int column) {
        return field[row][column];
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        final int realMiddle = m / 2 + 1;
        final StringBuilder sb = new StringBuilder(line).append(System.lineSeparator());
        String center = "";
        line.append(System.lineSeparator());
        for (int r = 1; r <= m; ++r) {
            line = new StringBuilder();
            line.append(" ");
            for (int c = 1; c <= m; ++c) {
                line.append(" ");
            }
            if (r % 2 == 1) {
                line.replace(realMiddle, realMiddle + 1, CELL_TO_STRING.get(field[r][realMiddle]));
            }
            int sub = Math.max(0, r - (m / 2 + 1));
            int cntL = (r - r % 2 - 2 * sub) / 2;
            int cntR = (r - r % 2 - 2 * sub) / 2;
            for (int j = realMiddle - 1 - r % 2; cntL > 0; j -= 2) {
                --cntL;
                line.replace(j, j + 1, CELL_TO_STRING.get(field[r][j]));
            }
            for (int j = realMiddle + 1 + r % 2; cntR  > 0; j += 2) {
                --cntR;
                line.replace(j, j + 1, CELL_TO_STRING.get(field[r][j]));
            }
            StringBuilder lineFinal = new StringBuilder();
            for (int k = 0; k < line.length(); ++k) {
                lineFinal.append(line.charAt(k));
                lineFinal.append(" ");
                lineFinal.append(" ");
            }
            lineFinal.append(r);
            sb.append(lineFinal);
            if (r == m / 2 + 1) {
                center = lineFinal.toString();
            }
            sb.append(System.lineSeparator());
        }
        StringBuilder ind = new StringBuilder();
        int first = 0;
        for (int i = 0; i < center.length(); ++i) {
            if (center.charAt(i) != ' ') {
                first = i;
                break;
            }
        }
        for (int i = 0; i < first; ++i) {
            ind.append(" ");
        }
        for (int cnt = 1; cnt <= m; ++cnt) {
            if (cnt <= 9) {
                ind.append(cnt);
                ind.append("  ");
            } else {
                ind.append(cnt);
                ind.append(" ");
            }
        }
        sb.insert(0, ind);
        return sb.toString();
    }
}

import java.util.*;

public class KnightsTour {

    private int[][] board;

    public static final int N = 8;

    static int[] updown = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] leftright = {-1, 1, -2, 2, -2, 2, -1, 1};

    public KnightsTour(int[][] data) {
        board = data;
    }

    static class Move {
        int degree, x, y;

        Move(int x, int y, int degree) {
            this.x = x;
            this.y = y;
            this.degree = degree;
        }

        public int getDegree() {
            return degree;
        }
    }

    public boolean playRandom(int[][] board, int initialX, int initialY, int moveNum) {
        this.board = board;

        board[initialX][initialY] = moveNum;

        if (moveNum == N*N) {
            return true;
        }

        List<Move> nextMovesList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int currow = initialX + updown[i];
            int curcol = initialY + leftright[i];

            if (valid(currow, curcol)) {
                int curdegree = countMoves(currow, curcol);
                nextMovesList.add(new Move(currow, curcol, curdegree));
            }
        }

        if (nextMovesList.size() == 0) {
            return false;
        }

        nextMovesList.sort(Comparator.comparingInt(move -> move.degree));



        return playRandom(board, nextMovesList.get(0).x, nextMovesList.get(0).y, moveNum + 1);
    }

    public boolean playComplete(int[][] board, int initialX, int initialY, int moveNum) {
        this.board = board;

        board[initialX][initialY] = moveNum;

        if (moveNum == N * N) {
            return true;
        }

        List<Move> nextMovesList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int currow = initialX + updown[i];
            int curcol = initialY + leftright[i];

            if (valid(currow, curcol)) {
                int curdegree = countMoves(currow, curcol);
                nextMovesList.add(new Move(currow, curcol, curdegree));
            }
        }

        nextMovesList.sort(Comparator.comparingInt(move -> move.degree));

        for (Move possibleMove : nextMovesList) {
            if (playComplete(board, possibleMove.x, possibleMove.y, moveNum + 1)) {
                return true;
            }

            board[possibleMove.x][possibleMove.y] = 0;
        }

        return false;
    }

    public boolean valid(int x, int y) {
        if (x > 7 || y > 7 || x < 0 || y < 0) {
            return false;
        } else if (board[x][y] != 0) {
            return false;
        }
        return true;
    }

    public int countMoves(int x, int y) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            if (valid(x + updown[i], y + leftright[i])) {
                count++;
            }
        }

        return count;
    }

    public void printBoard(int[][] board) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.printf("%2d ", board[r][c]);
            }
            System.out.println();
        }
    }
}
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private int[][] grid;

    private final int[] movelistX = {1, 0, 0, -1};
    private final int[] movelistY = {0, -1, 1, 0};

    public static class Move {
        int index;
        int xChange;
        int yChange;

        public Move (int x, int y, int priority){
            index = priority;
            xChange = x;
            yChange = y;
        }


    }

    public Maze(int [][] data)
    {
        grid = data;
    }

    public int[][] getGrid() {
        return grid;
    }

    public boolean tour(int x, int y, int [][] grid) {
        int initialX = x;
        int initialY = y;

        if (initialX == grid.length - 1 && initialY == grid[0].length - 1) {
            return true;
        }

        if (grid[0][0] == -1) {
            System.out.println("top left obstructed");
            return false;
        }

        grid[x][y] = 1;

        List<Move> movesList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            if (valid(grid, x + movelistX[i], y + movelistY[i])) {
                movesList.add(new Move(x + movelistX[i], y + movelistY[i], i));
            }
        }

        if (movesList.size() == 0) {
            return false;
        }

        for (Move possibleMove : movesList) {
            if (tour(possibleMove.xChange, possibleMove.yChange, grid)) {
                return true;
            } 
            else {
                grid[possibleMove.xChange][possibleMove.yChange] = 0;
            }
        }
        return false;
    }

    public boolean valid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length &&
            y >= 0 && y < grid[0].length &&
            grid[x][y] == 0;
    }

    public void printMaze(int[][] maze) {
        for (int[] row : maze) {
            for (int element : row) {
                System.out.printf("%3d ", element);
            }
            System.out.println();
        }
    }



}

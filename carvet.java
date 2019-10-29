import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class carvet {
    Scanner in;
    int[][] grid;
    final int EMPTY = -1;
    final int BLOCKED = -2;
    final int OUT_OF_BOUNDS = -3;

    carvet(InputStream input) {
        in = new Scanner(input);
        int m = in.nextInt(); // rows
        int n = in.nextInt(); // columns

        grid = new int[m][n];

        // −2 ≤ v ≤ 62 500.
        // -2 - blocked
        // -1 - empty
        for (int i = 0; i < m; i++) { // for each row i
            for (int j = 0; j < n; j++) { // col j
                int v = in.nextInt();
                grid[i][j] = v;
            }
        }

        int unc_x = in.nextInt() - 1; // location to uncover, -1 for zero index
        int unc_y = in.nextInt() - 1;

        // reading data, initialization complete

        List<Integer> carints = new ArrayList<>();
        if (uncover(unc_x, unc_y, carints)) {
            for (int ci = carints.size() - 1; ci >= 0; ci--) {
                System.out.print(carints.get(ci) + " ");
            }
        } else {
            System.out.println("impossible");
        }

    }

    // x, y is to be uncovered
    boolean uncover(int xo, int yo, List<Integer> cars) {

        int x = xo;
        int y = yo;

        while (true) {
            if (getGridPosType(x, y) == BLOCKED || getGridPosType(x, y) == OUT_OF_BOUNDS)
                return false;

            // find the kind of car covering the position
            // find out where the car needs to be moved to to uncover the position.
            int moveToX = x;
            int moveToY = y;

            int theOtherX = x;
            int theOtherY = y;

            if (grid[x][y] == getGridPosType(x + 1, y)) {
                moveToX = x + 2;
                theOtherX++;
            } else if (grid[x][y] == getGridPosType(x - 1, y)) {
                moveToX = x - 2;
                theOtherX--;
            } else if (grid[x][y] == getGridPosType(x, y + 1)) {
                moveToY = y + 2;
                theOtherY++;
            } else if (grid[x][y] == getGridPosType(x, y - 1)) {
                moveToY = y - 2;
                theOtherY--;
            } else {

            }

            // try moving the car there, if not moveable, try to uncover the square blocking
            // the move.

            if (getGridPosType(moveToX, moveToY) == EMPTY) {
                // solved
                cars.add(getGridPosType(x, y));
                return true;
            } else if (getGridPosType(moveToX, moveToY) == BLOCKED
                    || getGridPosType(moveToX, moveToY) == OUT_OF_BOUNDS) {
                // unsolveable
                // System.out.println("impossible");
                return false;
            } else {
                cars.add(getGridPosType(x, y));

                grid[theOtherX][theOtherY] = BLOCKED;
                grid[x][y] = BLOCKED;

                x = moveToX;
                y = moveToY;
            }
        }
    }

    int getGridPosType(int x, int y) {
        try {
            return grid[x][y];
        } catch (Exception e) {
            return OUT_OF_BOUNDS;
        }
    }

    public static void main(String[] args) {
        try {
            new carvet(System.in);
        } catch (Exception e) {
            System.out.println("impossible");
        }
    }
}

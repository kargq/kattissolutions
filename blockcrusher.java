import java.util.*;
import java.lang.*;

class Solution {
    Scanner in = new Scanner(System.in);
    /*

    Best at i j is best of all neighbors

    Don't need to consider side neighbors for level 1
     */
    Node[][] grid;
    int[][] dist;
    Node[][] prev;

    int rows, cols;

    Solution() {
        rows = in.nextInt();
        cols = in.nextInt();

        while (rows != 0) {
            grid = new Node[rows][cols];
            for (int r = 0; r < rows; r++) {
                String[] line = in.next().split("");
                for (int c = 0; c < cols; c++) {
                    int value = Integer.parseInt(line[c]);
                    grid[r][c] = new Node(r, c, value);
                }
            }

            // Input done


            // Neeeext
            rows = in.nextInt();
            cols = in.nextInt();
        }

    }

    void djk(int col) {
        Node source = grid[0][col];

        dist[0][col] = 0;

        int[][] priority = new int[rows][cols];

        // Init stuff

        PriorityQueue<Node> queue = new PriorityQueue<>(rows * cols, Comparator.comparingInt((a) -> a.dist));

        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dist[r][c] = Integer.MAX_VALUE;
                prev[r][c] = null;

            }
        }


    }

    Node gridGet(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return null;
        } else return grid[r][c];
    }

    static <E> List<E> list(E... items) {
        ArrayList<E> result = new ArrayList<>();
        for (E item : items) {
            if (item != null) result.add(item);
        }
        return result;
    }

    class Node {
        int row;
        int col;
        int value;
        int dist;

        Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            return obj.hashCode() == hashCode();
        }

        @Override
        public int hashCode() {
            return 1000 * row + col;
        }

        List<Node> getNeighbors() {
            return Solution.list(
                    gridGet(row - 1, col), // n
                    gridGet(row - 1, col - 1), // n w
                    gridGet(row - 1, col + 1), // n e
                    gridGet(row, col - 1), // w
                    gridGet(row, col + 1) // e

            );
        }

        @Override
        public String toString() {
            return "[" + row + "," + col + "," + value + "]";
        }

    }

    public static void main(String[] args) {
        new Solution();
    }
}
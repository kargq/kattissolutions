import java.util.*;
import java.lang.Math.*;

class Solution {
    Scanner in;
    int[][] map;
    int r, c;
    Node[][] nodes;
    List<Node> nodesQ = null;
    boolean[][] visited = null;
    Solution(Scanner _in) {
        this.in = _in;
        r = in.nextInt();
        c = in.nextInt();
        map = new int[r][c];
        nodes = new Node[r][c];
        for(int i = 0; i < r; i++) {
            int rowVal = in.nextInt();
            for(int j = 0; j < c; j++) {
                int place = ((int) Math.pow(10, (c - j - 1)));
                map[i][j] = rowVal / place;
                nodes[i][j] = new Node(i, j);
                rowVal -= place * map[i][j];
            }
        }
        int queries = in.nextInt();
        for(int i = 0; i < queries; i++) {
            resolveQuery();
        }
    }

    public void resolveQuery() {
        int r1 = in.nextInt() - 1;
        int c1 = in.nextInt() - 1;
        int r2 = in.nextInt() - 1;
        int c2 = in.nextInt() - 1;

        // Can you go from r1, c1 to r2, c2

        // bfs from one point, path exists if other point found.

        // Some sort of caching? Maintain a set along with the search

        // Ohh this is union find, not exactly but also kind of

        Node from = nodes[r1][c1];
        Node to = nodes[r2][c2];

        if(find(from, to)) {
            if(from.getVal() == 0) {
                print("binary");
            } else {
                print("decimal");
            }
        } else {
            print("neither");
        }

    }

    public void union(Node node1, Node node2) {
        node2.parent = node1;
    }

    public boolean find(Node node1, Node node2) {
        Node node1p = ultimateDaddy(node1);
        Node node2p = ultimateDaddy(node2);

        if(node1p == node2p) return true;
        else {
            return bfs(node1p, node2p);
        }
    }

    public Node ultimateDaddy(Node node) {
        if(node.parent == node) return node;
        else { 
            Node result = ultimateDaddy(node.parent); 
            node.parent = result;
            return result;
        }
    }

    public void addToQ(Node node){
        if(node != null && !visited[node.row][node.col]) {
            nodesQ.add(node);
            visited[node.row][node.col] = true;
        }
    }

    public boolean bfs(Node from, Node target) {
        visited = new boolean[r][c];
        nodesQ = new LinkedList<Node>();
        nodesQ.add(from);
        while(nodesQ.length() > 0) {
            Node curr = nodesq.pop();
            union(curr, from);
            if(curr.equals(target)) {
                return true;
            }
            Node n = node.n();
            Node s = node.s();
            Node e = node.e();
            Node w = node.w();
            // Add unvisited accessible neighbours
            addToQ(n);
            addToQ(s);
            addToQ(e);
            addToQ(w);
        }
        return false;
    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }

    public void printMap() {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void debug(Object o) {
        System.out.println("DEBUG: " + o.toString());
    }

    public static void main(String[] args) {
        new Solution(new Scanner(System.in));
    }

    class Node {
        int row;
        int col;
        Node parent = null;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
            this.parent = this;
        }

        Node getNeighbour(int rd, int cd) {
            int nRow = row + rd;
            int nCol = col + cd;
            if(nRow >= 0 && nCol >= 0 && nCol < c && nRow < r) {
                Node resNode = nodes[nRow][nCol];
                if(resNode.getVal() == getVal()) {
                    return resNode;
                }
            }
            return null;
        }

        Node n() {
            getNeighbour(-1, 0);
        }

        Node s() {
            getNeighbour(1, 0);
        }

        Node e() {
            getNeighbour(0, 1);
        }

        Node w() {
            getNeighbour(0, -1);
        }

        int getVal() {
            return map[row][col];
        }

        @Override
        public boolean equals(Node obj) {
            return this.row == obj.row && this.col == obj.col;
        }
    }
}
import java.util.*;
import java.lang.Math.*;

class Solution {
    Scanner in;
    int[][] map;
    int r, c;
    Node[][] nodes;
    LinkedList<Node> nodesQ = new LinkedList<>();
    boolean[][] visited = null;

    Solution(Scanner _in) {
        this.in = _in;
        r = in.nextInt();
        c = in.nextInt();
        map = new int[r][c];
        nodes = new Node[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String rowVal = in.next();
            for (int j = 0; j < c; j++) {
                String strVal = rowVal.substring(j, j + 1);
                int val = strVal.equals("0") ? 0 : 1;  
                map[i][j] = val;
                nodes[i][j] = new Node(i, j);
            }
        }
        int queries = in.nextInt();
        for (int i = 0; i < queries; i++) {
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

        if (find(from, to)) {
            if (from.getVal() == 0) {
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
        printSet();
    }

    public boolean find(Node node1, Node node2) {
        Node node1p = ultimateDaddy(node1);
        Node node2p = ultimateDaddy(node2);

        if (node1p.equals(node2p)) {
            debug("It help");
            return true;
        }
        else {
            return search(node1p, node2p);
        }
    }

    void printSet() {
        HashMap<Node, List<Node>> nodeMap = new HashMap<>();
        for(Node[] nodeRow: nodes) {
            for(Node node: nodeRow) {
                Node dad = ultimateDaddy(node);
            }
        }
        for(Node[] nodeRow: nodes) {
            for(Node node: nodeRow) {
                hj gvman,s Node dad = ultimateDaddy(node);
                if(nodeMap.containsKey(dad)) {
                    nodeMap.get(dad).add(node);
                } else {
                    List<Node> newList = new ArrayList<>();
                    newList.add(node);
                    nodeMap.put(dad, newList);
                }
            }
        }
        for(Node key: nodeMap.keySet()) {
            System.out.print(key + ": ");
            for(Node node : nodeMap.get(key)) {
                System.out.print(node + ", ");
            }
            System.out.println();
        }
    }

    public Node ultimateDaddy(Node node) {
        if (node.parent == node) return node;
        else {
            Node result = ultimateDaddy(node.parent);
            node.parent = result;
            return result;
        }
    }

    public void addToQ(Node node) {
        if (node != null && !visited[node.row][node.col]) {
            nodesQ.add(node);
            visited[node.row][node.col] = true;
        }
    }

    boolean isVisited(Node node) {
        return visited[node.row][node.col];
    }

    boolean dfs(Node from, Node target) {
        if(from == null) {
            return false;
        } else if(from.equals(target)) {
            return true;
        }
        List<Node> sortedNeighbours = from.getNeighbours();
        sortedNeighbours.sort((a, b) -> dist(a, target) - dist(b, target));
        for(Node curr : sortedNeighbours) {
            if(isVisited(curr)) continue;
        }
        for(Node curr : sortedNeighbours) {
            if(isVisited(curr)) continue;
            markVisited(curr);
            union(curr, from);
            if(dfs(curr, target)) return true;
        }
        return false;
    }

    void markVisited(Node node) {
        visited[node.row][node.col] = true;
    }

    boolean search(Node from, Node target) {
        cleanVisited();
        return dfs(from, target);
    }

    void cleanVisited() {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                visited[i][j] = false;
            }
        }
    }
    public boolean bfs(Node from, Node target) {
        if(from == null) {
            return false;
        }
        cleanVisited();
        nodesQ.clear();
        nodesQ.add(from);
        while (nodesQ.size() > 0) {
            Node curr = nodesQ.pop();
            union(curr, from);
            if (curr.equals(target)) {
                return true;
            }
            Node n = curr.n();
            Node s = curr.s();
            Node e = curr.e();
            Node w = curr.w();
            // Add unvisited accessible neighbours
            addToQ(n);
            addToQ(s);
            addToQ(e);
            addToQ(w);
        }
        return false;
    }

    public int dist(Node node1, Node node2) {
        return (int) Math.sqrt(Math.pow(node1.row - node2.row, 2) + Math.pow(node1.col - node2.col, 2));
    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }

    public void printMap() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
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
            if (nRow >= 0 && nCol >= 0 && nCol < c && nRow < r) {
                Node resNode = nodes[nRow][nCol];
                if (resNode.getVal() == getVal()) {
                    return resNode;
                }
            }
            return null;
        }

        Node n() {
            return getNeighbour(-1, 0);
        }

        Node s() {
            return getNeighbour(1, 0);
        }

        Node e() {
            return getNeighbour(0, 1);
        }

        Node w() {
            return getNeighbour(0, -1);
        }

        int getVal() {
            return map[row][col];
        }

        List<Node> getNeighbours(){
            List<Node> result = new ArrayList<>(4);
            if(n() != null) result.add(n());
            if(s() != null) result.add(s());
            if(e() != null) result.add(e());
            if(w() != null) result.add(w());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() != Node.class) {
                return false;
            }
            Node node = (Node) obj;
            return this.row == node.row && this.col == node.col;
        }

        @Override
        public String toString() {
            return "Node [" + row + "," + col + "]";
        }
    }
}
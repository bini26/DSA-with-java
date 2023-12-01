import java.util.*;

public class DisjointSet {

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n = 4;// vertices
    static int rank[] = new int[n];
    static int par[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        // pathCpmpression optimization
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void KruskalsMST(ArrayList<Edge> edges, int v) {
        init();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;
        for (int i = 0; count < v - 1; i++) {
            Edge e = edges.get(i);
            int parA = find(e.src);// src=a
            int parB = find(e.dest);// src=b
            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }

    public void helper(int[][] image, int sr, int sc, int color, boolean vist[][], int orgColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vist[sr][sc]
                || image[sr][sc] != orgColor) {
            return;
        }
        // left
        helper(image, sr, sc - 1, color, vist, orgColor);

        // right
        helper(image, sr, sc + 1, color, vist, orgColor);
        // up
        helper(image, sr - 1, sc, color, vist, orgColor);
        // down
        helper(image, sr + 1, sc, color, vist, orgColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vist[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vist, image[sr][sc]);
        return image;
    }
    // public static void main(String[] args) {
    // init();
    // union(1, 3);
    // System.out.println(find(3));
    // union(2, 4);
    // union(1, 4);
    // System.out.println(find(3));
    // System.out.println(find(4));
    // union(1, 5);
    // }

    public static void main(String[] args) {
        // Kruskals Algorithm
        // int v = 4;
        // ArrayList<Edge> edge = new ArrayList<>();
        // createGraph(edge);
        // KruskalsMST(edge, v);
        // Kruskals Algorithm

        // Flood Fill

    }
}

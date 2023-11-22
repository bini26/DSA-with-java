import java.util.*;

public class HeapQuestions {
    // Sliding window
    public static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // ascending ma vaye
            // return this.val-p2.val;

            // descending
            return p2.val - this.val;
        }
    }

    // Weakest Soldier
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSql;
        int idx;

        public Point(int x, int y, int distSql, int idx) {
            this.x = x;
            this.y = y;
            this.distSql = distSql;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSql - p2.distSql;
        }
    }

    public static void main(String[] args) {
        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int distSql = (pts[i][0] * pts[i][0]) + (pts[i][1] * pts[i][1]);
            pq.add(new Point(pts[i][0], pts[i][1], distSql, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }
        // Connect N Ropes
        int rope[] = { 2, 3, 3, 4, 6 };
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for (int i = 0; i < rope.length; i++) {
            pq2.add(rope[i]);
        }
        int cost = 0;
        while (pq2.size() > 1) {
            int min = pq2.remove();
            int min2 = pq2.remove();
            cost = min + min2;
            pq2.add(cost);
        }

        System.out.println("My cost is " + cost);
        // Connect N Ropes

        // Weakest soldier
        int army[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 }
        };
        int k1 = 2;
        PriorityQueue<Row> pq3 = new PriorityQueue<>();
        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq3.add(new Row(count, i));
        }
        for (int i = 0; i < k1; i++) {
            System.out.println("R" + pq3.remove().idx);
        }
        // Sliding window maximum
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k3 = 3;// window size
        int res[] = new int[arr.length - k3 + 1];
        PriorityQueue<Pair> pq4 = new PriorityQueue<>();
        for (int i = 0; i < k3; i++) {
            pq4.add(new Pair(arr[i], i));
        }
        res[0] = pq4.peek().val;
        for (int i = k3; i < arr.length; i++) {
            while (pq4.size() > 0 && pq4.peek().idx <= (i - k)) {
                pq4.remove();
            }
            pq4.add(new Pair(arr[i], i));
            res[i - k3 + 1] = pq4.peek().val;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + "  ");
        }
        System.out.println();
    }

}

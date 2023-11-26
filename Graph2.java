import java.util.*;
import java.util.LinkedList;

public class Graph2 {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 vertices
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));
        // 1 vertces
        graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 3));
        // 2 vertices
        graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 4));
        // 3 vertices
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 0));
        // 4 vertices

        // graph[4].add(new Edge(4, 3));

    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean visited[], int curr, int par) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                if (detectCycleUtil(graph, visited, e.dest, curr)) {

                    return true;
                }
            } else if (visited[e.dest] && e.dest != par) {
                return true;

            }

        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (color[e.dest] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if (color[e.dest] == color[curr]) {
                            return false;
                        }
                    }

                }
            }
        }
        return true;
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCycleUtil(graph, i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean visited[], boolean stack[]) {
        visited[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            if (!visited[e.dest] && isCycleUtil(graph, e.dest, visited, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {

                topologicalSortUtil(graph, i, visited, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop() + "  ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int curr, boolean visited[], Stack s) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topologicalSortUtil(graph, e.dest, visited, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        // System.out.println(detectCycle(graph));

        // System.out.println(isBipartite(graph));
        topologicalSort(graph);
    }
}

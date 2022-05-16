package graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedUnweightedGraph implements GraphUtils {
    private int V;
    private int E;
    private List<List<Integer>> adj;

    public DirectedUnweightedGraph(int V) {
        this.V = V;
        this.E = 0;

        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    @Override
    public void addEdge(int a, int b) {
        adj.get(a).add(b);
        E++;
    }

    @Override
    public Iterable<Integer> getAdj(int vertex) {
        return adj.get(vertex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(V + " вершин, " + E + " рёбер\n");
        for (int i = 0; i < V; i++) {
            sb.append(i).append(": ");
            for (int j : this.getAdj(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

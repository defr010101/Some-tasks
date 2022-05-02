package graph;

import java.util.*;

public class Graph {
    public static void main(String[] args) {
        int N = 5;
        int M = 5;
        List<List<Integer>> graph = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
            visited.add(false);
        }
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a-1).add(b-1);
        }
        BFS(graph, visited, 0);
        scanner.close();
    }

    public static void DFS(List<List<Integer>> graph, List<Boolean> visited, int node) {
        if (visited.get(node)) {
            return;
        }
        visited.set(node, true);
        System.out.println(node + 1);
        for (Integer el : graph.get(node)) {
            DFS(graph, visited, el);
        }
    }

    public static void BFS(List<List<Integer>> graph, List<Boolean> visited, int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited.set(node, true);
        queue.add(node);
        while (!queue.isEmpty()) {
            int vertex = queue.peek(); queue.poll();
            System.out.println(vertex + 1);
            for (Integer el : graph.get(vertex)) {
                if (visited.get(el)) continue;
                visited.set(el, true);
                queue.add(el);
            }
        }
    }
}

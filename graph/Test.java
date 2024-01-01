package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Test {
    private int vertice;
    private int edges;
    private DirectedUnweightedGraph graph;
    private boolean[] visited;

    /* Optional */
    private int[] path;
    public Test() {
        try(Scanner scanner = new Scanner(new FileInputStream("D:\\JavaProjects\\untitled6\\src\\main\\java\\graph\\data.txt"))) {
            vertice = scanner.nextInt();
            edges = scanner.nextInt();
            graph = new DirectedUnweightedGraph(vertice);
            visited = new boolean[vertice];

            /* Optional */
            path = new int[vertice];
            for (int i = 0; i < edges; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                graph.addEdge(a, b);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void DFS(int x) {
        if (visited[x]) return;
        System.out.println(x);
        visited[x] = true;
        for (var v : graph.getAdj(x)) {
            DFS(v);
        }
    }
    
    public void BFS(int x) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(x);
        visited[x] = true;
        path[x] = 0;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.println(v);
            for (int el : graph.getAdj(v)) {
                if (visited[el]) continue;
                queue.add(el);
                visited[el] = true;

                path[el] = path[v] + 1;
            }
        }
    }

    public static void main(String[] args) {
        Test work = new Test();

        work.BFS(0);
        int i = 0;
        for (int a : work.path) {
            System.out.println(i + ": " + a);
            i++;
        }
    }
}

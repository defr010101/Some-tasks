package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class tSearchCycle {

    private static List<List<Integer>> adj;
    private static int N;
    private static int M;
    private static boolean[] visited;
    private static int[] color;
    private static int[] parent;
    private static int cycleStart, cycleEnd;

    public static boolean dfs(int v) {
        color[v] = 1;

        for (int u : adj.get(v)) {
            if (color[u] == 0) {
                parent[u] = v;
                if (dfs(u)) {
                    return true;
                }
            } else if (color[u] == 1) {
                cycleStart = u;
                cycleEnd = v;
                return true;
            }
        }

        color[v] = 2;
        return false;
    }

    public static void findCycle() {
        Arrays.fill(color, 0);
        Arrays.fill(parent, -1);
        Arrays.fill(visited, false);

        cycleStart = -1;

        dfs(0);

        if (cycleStart == -1) {
            System.out.println("Acyclic");
        } else {
            List<Integer> cycle = new ArrayList<>();
            for (int v = cycleEnd; v != cycleStart; v = parent[v]) {
                cycle.add(v);
            }
            cycle.add(cycleStart);

            System.out.println(cycle.size());

            Collections.reverse(cycle);
            for (int el : cycle) {
                System.out.print(el + " ");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner =
               new Scanner(new FileReader("D:\\JavaProjects\\untitled6\\src\\main\\java\\graph\\data.txt"));
        N = scanner.nextInt();
        M = scanner.nextInt();
        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        color = new int[N];
        parent = new int[N];
        visited = new boolean[N];
        int a, b;
        for (int i = 0; i < M; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            adj.get(a-1).add(b-1);
            adj.get(b-1).add(a-1);
        }

        findCycle();

    }
}

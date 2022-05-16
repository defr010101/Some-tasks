/*
Поиск компонент связности
 */

package graph;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class tSearchComponents {
    public static void DFS(List<List<Integer>> adj, boolean[] visited, int[] component, int countComponent, int x) {
        visited[x] = true;
        component[x] = countComponent;
        for (int el : adj.get(x)) {
            if (visited[el]) continue;
            DFS(adj, visited, component, countComponent, el);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            adj.get(a-1).add(b-1);
            adj.get(b-1).add(a-1);
        }

        int countComponent = 0;
        int[] component = new int[N];

        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                countComponent++;
                DFS(adj, visited, component, countComponent, i);
            }
        }

        System.out.println(countComponent);
        for (int el : component) {
            System.out.print(el + " ");
        }
    }
}

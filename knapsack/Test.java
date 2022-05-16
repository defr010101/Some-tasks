/*
Knapsack problem with answer recovery
 */

package knapsack;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int weightLimit = 7;
        List<Item> items = new ArrayList<>();
        items.add(new Item(2, 8));
        items.add(new Item(3, 7));
        items.add(new Item(4, 10));

        int[][] values = new int[items.size() + 1][weightLimit + 1];
        Arrays.fill(values[0], 0);
        for (int i = 1; i < values.length; i++) {
            Item item = items.get(i-1);
            for (int j = 0; j < values[i].length; j++) {
                if (j - item.weight >= 0) {
                    values[i][j] = Math.max(item.cost + values[i-1][j-item.weight], values[i-1][j]);
                } else {
                    values[i][j] = values[i-1][j];
                }
            }
        }

        List<Item> result = new ArrayList<>();

        int n = items.size();
        int w = weightLimit;
        while (n != 0) {
            if (values[n][w] != values[n-1][w]) {
                result.add(items.get(n-1));

                w = w - items.get(n-1).weight;
            }
            n--;
        }

        result.forEach(x -> System.out.print(x + " "));
        System.out.println("\nMax value = " + values[items.size()][weightLimit]);
    }
}

package knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicKnapsack {
    private void calculateValuesForItems(int[][] values, List<Item> items) {
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
    }

    public int maxValue(int weightLimit, List<Item> items) {
        int[][] values = new int[items.size()+1][weightLimit+1];
        calculateValuesForItems(values, items);



        return values[items.size()][weightLimit];
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(6, 23));
        items.add(new Item(2, 8));
        items.add(new Item(2, 8));
        items.add(new Item(2, 9));
        items.add(new Item(2, 10));
        items.add(new Item(3, 15));

        DynamicKnapsack k2 = new DynamicKnapsack();
        int result = k2.maxValue(10, items);
        System.out.println(result);
    }
}

package knapsack;

import java.util.ArrayList;
import java.util.List;

public class KnapsackBruteForce {

    private List<Item> items;
    private int weightLimit;

    public KnapsackBruteForce(List<Item> items, int weightLimit) {
        this.items = items;
        this.weightLimit = weightLimit;
    }

    public void addItem(int weight, int cost) {
        items.add(new Item(weight, cost));
    }

    public int maxValue() throws IllegalAccessException {
        if (items.size() > 32) {
            throw new IllegalAccessException("items count must be less that 32");
        }

        int maxCost = 0;
        List<Item> result = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, items.size()); i++) {
            String binary = intToBinaryString(i, items.size());
            int localWeight = 0;
            int localCost = 0;

            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    localWeight += items.get(j).weight;
                    localCost += items.get(j).cost;
                }
            }

            if (localWeight <= weightLimit && localCost > maxCost) {
                maxCost = localCost;
                result = formResult(binary);
            }
        }

        result.forEach(System.out::println);
        System.out.println("Max cost: " + maxCost);
        return maxCost;
    }


    private String intToBinaryString(int value, int length) {
        String binary = Integer.toBinaryString(value);
        return String.format("%"+length+"s", binary).replaceAll(" ", "0");
    }

    private List<Item> formResult(String binary) {
        List<Item> result = new ArrayList<>();
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                result.add(items.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) throws IllegalAccessException {
        KnapsackBruteForce k = new KnapsackBruteForce(new ArrayList<>(), 10);
        k.addItem(6, 23);
        k.addItem(2, 8);
        k.addItem(2, 8);
        k.addItem(2, 9);
        k.addItem(2, 10);
        k.addItem(3, 15);

        int max = k.maxValue();
    }
}

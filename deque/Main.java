package deque;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("1");
        deque.add("2");
        deque.add("3");
        deque.add("4");

        //print(deque);

        List<Integer> a = new ArrayList<>(Arrays.asList(5, 12));
        swap(a, 0, 1);
        a.forEach(System.out::println);
    }

    public static int print(Deque<String> deque) {
        for (String element : deque) {
            System.out.println("element from deque: " + element);
        }

        return 2;
    }

    public static void swap(List<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }
}

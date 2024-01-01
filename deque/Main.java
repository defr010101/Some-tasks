package deque;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add("1");
        deque.add("2");
        deque.add("3");

        for (String item : deque.reversed()) {
            System.out.println(item);
        }
    }
}

package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("1");
        deque.add("2");
        deque.add("3");
	deque.add("4");

        for (String element : deque.reversed()) {
            System.out.println(element);
        }
    }
}

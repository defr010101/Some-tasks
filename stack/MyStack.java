package stack;

import java.util.EmptyStackException;

public class MyStack<T> {
    private StackNode<T> top;

    public void push(T item) {
        StackNode<T> newNode = new StackNode<>(item);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (this.isEmpty()) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (this.isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

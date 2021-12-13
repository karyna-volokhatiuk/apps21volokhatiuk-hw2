package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue;

    public Queue() {
        queue = new ImmutableLinkedList();
    }

    public Object peek() {
        return queue.getFirst();
    }

    public Object dequeue() {
        Object value = peek();
        queue = queue.removeFirst();
        return value;
    }

    public void enqueue(Object e) {
        queue = queue.addLast(e);
    }
}

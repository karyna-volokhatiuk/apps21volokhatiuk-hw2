package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private final Node head;
    private final Node tail;

    private final int size;

    public ImmutableLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.size = 0;
    }

    public ImmutableLinkedList(Object[] elements) {
        this.size = elements.length;
        this.head = new Node();

        if (elements.length == 0) {
            this.tail = new Node();
        } else {
            head.setValue(elements[0]);
            Node curr = head;
            Node newNode;
            for (int i = 1; i < size; i++) {
                newNode = new Node();
                newNode.setValue(elements[i]);
                newNode.setPrevious(curr);
                curr.setNext(newNode);
                curr = newNode;
            }
            tail = curr;
        }
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }

        Object[] newElements = new Object[size + 1];

        for (int i = 0; i < size + 1; i++) {
            if (i < index) {
                newElements[i] = get(i);
            } else if (i == index) {
                newElements[i] = e;
            } else {
                newElements[i] = get(i-1);
            }
        }
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }

        Object[] newElements = new Object[size + c.length];

        for (int i = 0; i < size + c.length; i++) {
            if (i < index) {
                newElements[i] = get(i);
            } else if (i < index + c.length) {
                newElements[i] = c[i - index];
            } else {
                newElements[i] = get(i - c.length);
            }
        }

        return new ImmutableLinkedList(newElements);
    }

    @Override
    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }

        Node curr = head;
        for(int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }

        Object[] newElements = new Object[size - 1];

        for (int i = 0; i < size; i++) {
            if (i < index) {
                newElements[i] = get(i);
            } else if (i > index) {
                newElements[i - 1] = get(i);
            }
        }

        return new ImmutableLinkedList(newElements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }

        Object[] newElements = new Object[size];

        for (int i = 0; i < size; i++) {
            if (i < index) {
                newElements[i] = get(i);
            } else if (i > index) {
                newElements[i] = get(i-1);
            } else {
                newElements[i] = e;
            }
        }

        return new ImmutableLinkedList(newElements);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (get(i) == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] elements = new Object[size];
        Node curr = head;
        for (int i = 0; i < size; i++) {
            elements[i] = curr.getValue();
            curr = curr.getNext();
        }
        return elements;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] newElements = new Object[size + 1];
        newElements[0] = e;
        for (int i = 1; i < size + 1; i++) {
            newElements[i] = get(i - 1);
        }
        return new ImmutableLinkedList(newElements);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] newElements = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            newElements[i] = get(i);
        }

        newElements[size] = e;

        return new ImmutableLinkedList(newElements);
    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        if (size < 1) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
        return head.getValue();
    }

    public Object getLast() {
        if (size < 1) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        if (size < 1) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }

        Object[] newElements = new Object[size-1];
        for (int i = 1; i < size; i++) {
            newElements[i - 1] = get(i);
        }
        return new ImmutableLinkedList(newElements);
    }

    public ImmutableLinkedList removeLast() {
        if (size < 1) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }

        Object[] newElements = new Object[size-1];
        for (int i = 0; i < size - 1; i++) {
            newElements[i] = get(i);
        }
        return new ImmutableLinkedList(newElements);
    }
}

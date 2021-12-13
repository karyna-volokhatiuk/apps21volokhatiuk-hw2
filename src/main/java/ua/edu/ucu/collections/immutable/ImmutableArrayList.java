package ua.edu.ucu.collections.immutable;


public final class ImmutableArrayList implements ImmutableList {
    private final Object[] elements;
    private final int size;

    public ImmutableArrayList(Object[] elements) {
        this.size = elements.length;
        this.elements = elements.clone();
    }

    public ImmutableArrayList() {
        this.elements = new Object[0];
        this.size = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index > size){
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        Object[] new_elements = new Object[size + 1];

        for (int i = 0; i < size + 1; i++){
            if (i < index){
                new_elements[i] = elements[i];
            } else if (i == index){
                new_elements[i] = e;
            } else {
                new_elements[i] = elements[i - 1];
            }
        }

        return new ImmutableArrayList(new_elements);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > size){
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        Object[] new_elements = new Object[size + c.length];

        for (int i = 0; i < size + c.length; i++){
            if (i < index){
                new_elements[i] = elements[i];
            } else if (i < index + c.length){
                new_elements[i] = c[i - index];
            } else {
                new_elements[i] = elements[i - c.length];
            }
        }

        return new ImmutableArrayList(new_elements);
    }

    @Override
    public Object get(int index) {
        if (index >= size){
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        return elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= size){
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        Object[] new_elements = new Object[size - 1];

        for (int i = 0; i < size; i ++){
            if (i < index) {
                new_elements[i] = elements[i];
            } else if (i > index) {
                new_elements[i - 1] = elements[i];
            }
        }

        return new ImmutableArrayList(new_elements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= size){
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        Object[] new_elements = new Object[size];

        for (int i = 0; i < size; i ++){
            if (i < index) {
                new_elements[i] = elements[i];
            } else if (i > index) {
                new_elements[i] = elements[i - 1];
            } else {
                new_elements[i] = e;
            }
        }

        return new ImmutableArrayList(new_elements);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++){
            if (elements[i] == e){
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
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return elements.clone();
    }
}

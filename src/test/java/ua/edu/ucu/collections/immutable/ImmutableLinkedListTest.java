package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class ImmutableLinkedListTest extends TestCase {
    ImmutableLinkedList list, emptyList;

    public void setUp() throws Exception {
        super.setUp();
        Object[] elements = {3, 35.9, "apple"};
        list = new ImmutableLinkedList(elements);
        emptyList = new ImmutableLinkedList();
    }

    public void testAdd() {
        assertArrayEquals(new Object[]{3, 35.9, "apple", 21}, list.add(21).toArray());
    }

    public void testAddIndex() {
        assertArrayEquals(new Object[]{3, 21, 35.9, "apple"}, list.add(1, 21).toArray());
    }

    public void testAddIncorrectIndex() {
        try {
            list.add(5, "incorrect_idx");
        } catch(IndexOutOfBoundsException exc) {
            assertEquals("Index is out of range.", exc.getMessage());
        }
    }

    public void testAddAll() {
        assertArrayEquals(new Object[]{3, 35.9, "apple", 21, "hello"}, list.addAll(new Object[]{21, "hello"}).toArray());
    }

    public void testAddAllIncorrectIndex() {
        try {
            list.addAll(5, new Object[] {"incorrect_idx_1", "incorrect_idx_2"});
        } catch(IndexOutOfBoundsException exc) {
            assertEquals("Index is out of range.", exc.getMessage());
        }
    }

    public void testAddAllIndex() {
        assertArrayEquals(new Object[]{3, 21, "hello", 35.9, "apple"}, list.addAll(1, new Object[]{21, "hello"}).toArray());
    }

    public void testGet() {
        assertEquals(3, list.get(0));
    }

    public void testGetIncorrectIndex() {
        try {
            list.get(5);
        } catch(IndexOutOfBoundsException exc) {
            assertEquals("Index is out of range.", exc.getMessage());
        }
    }

    public void testRemove() {
        assertArrayEquals(new Object[]{35.9, "apple"}, list.remove(0).toArray());
        assertArrayEquals(new Object[]{3, 35.9}, list.remove(2).toArray());
    }

    public void testRemoveIncorrectIndex() {
        try {
            list.remove(5);
        } catch(IndexOutOfBoundsException exc) {
            assertEquals("Index is out of range.", exc.getMessage());
        }
    }

    public void testSet() {
        assertArrayEquals(new Object[]{3, 35.9, 6}, list.set(2, 6).toArray());
        assertArrayEquals(new Object[]{6, 35.9, "apple"}, list.set(0, 6).toArray());
    }

    public void testSetIncorrectIndex() {
        try {
            list.set(5, "set_incorrect_idx");
        } catch(IndexOutOfBoundsException exc) {
            assertEquals("Index is out of range.", exc.getMessage());
        }
    }

    public void testIndexOf() {
        assertEquals(0, list.indexOf(3));
        assertEquals(-1, list.indexOf(4));
    }

    public void testSize() {
        assertEquals(3, list.size());
    }

    public void testClear() {
        assertArrayEquals(new Object[]{}, list.clear().toArray());
    }

    public void testIsEmpty() {
        assertFalse(list.isEmpty());
        assertTrue(emptyList.isEmpty());
    }

    public void testToArray() {
        assertArrayEquals(new Object[]{3, 35.9, "apple"}, list.toArray());
    }

    public void testAddFirst() {
        assertArrayEquals(new Object[]{5, 3, 35.9, "apple"}, list.addFirst(5).toArray());
    }

    public void testAddLast() {
        assertArrayEquals(new Object[]{3, 35.9, "apple", 5}, list.addLast(5).toArray());
    }

    public void testGetHead() {
        assertEquals(3, list.getHead().getValue());
    }

    public void testGetTail() {
        assertEquals("apple", list.getTail().getValue());
    }

    public void testGetFirst() {
        assertEquals(3, list.getFirst());
    }

    public void testGetFirstEmpty() {
        try {
            emptyList.getFirst();
        } catch(IndexOutOfBoundsException exc) {
            assertEquals("Index is out of range.", exc.getMessage());
        }
    }

    public void testGetLast() {
        assertEquals("apple", list.getLast());
    }

    public void testGetLastEmpty() {
        try {
            emptyList.getLast();
        } catch(IndexOutOfBoundsException exc) {
            assertEquals("Index is out of range.", exc.getMessage());
        }
    }

    public void testRemoveFirst() {
        assertArrayEquals(new Object[]{35.9, "apple"}, list.removeFirst().toArray());
    }

    public void testRemoveFirstEmpty() {
        try {
            emptyList.removeFirst();
        } catch(IndexOutOfBoundsException exc) {
            assertEquals("Index is out of range.", exc.getMessage());
        }
    }

    public void testRemoveLast() {
        assertArrayEquals(new Object[]{3, 35.9}, list.removeLast().toArray());
    }

    public void testRemoveLastEmpty() {
        try {
            emptyList.removeLast();
        } catch(IndexOutOfBoundsException exc) {
            assertEquals("Index is out of range.", exc.getMessage());
        }
    }
}
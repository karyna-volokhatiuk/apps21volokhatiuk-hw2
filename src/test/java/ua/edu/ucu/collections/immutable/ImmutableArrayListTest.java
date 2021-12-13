package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class ImmutableArrayListTest extends TestCase {
    ImmutableArrayList list, emptyList;

    public void setUp() throws Exception {
        super.setUp();
        Object[] elements = {3, 35.9, "apple"};
        list = new ImmutableArrayList(elements);
        emptyList = new ImmutableArrayList();
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
            assertEquals("Index out of range.", exc.getMessage());
        }
    }


    public void testAddAll() {
        assertArrayEquals(new Object[]{3, 35.9, "apple", 21, "hello"}, list.addAll(new Object[]{21, "hello"}).toArray());
    }

    public void testAddAllIndex() {
        assertArrayEquals(new Object[]{3, 21, "hello", 35.9, "apple"}, list.addAll(1, new Object[]{21, "hello"}).toArray());
    }

    public void testAddAllIncorrectIndex() {
        try {
            list.addAll(5, new Object[] {"incorrect_idx_1", "incorrect_idx_2"});
        } catch(IndexOutOfBoundsException exc) {
            assertEquals("Index out of range.", exc.getMessage());
        }
    }

    public void testGet() {
        assertEquals(3, list.get(0));
    }

    public void testGetIncorrectIndex() {
        try {
            list.get(5);
        } catch(IndexOutOfBoundsException exc) {
            assertEquals("Index out of range.", exc.getMessage());
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
            assertEquals("Index out of range.", exc.getMessage());
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
            assertEquals("Index out of range.", exc.getMessage());
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
}
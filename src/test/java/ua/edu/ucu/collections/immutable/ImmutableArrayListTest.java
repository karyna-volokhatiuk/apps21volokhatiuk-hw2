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

    public void testAddAll() {
        assertArrayEquals(new Object[]{3, 35.9, "apple", 21, "hello"}, list.addAll(new Object[]{21, "hello"}).toArray());
    }

    public void testAddAllIndex() {
        assertArrayEquals(new Object[]{3, 21, "hello", 35.9, "apple"}, list.addAll(1, new Object[]{21, "hello"}).toArray());
    }

    public void testGet() {
        assertEquals(3, list.get(0));
    }

    public void testRemove() {
        assertArrayEquals(new Object[]{35.9, "apple"}, list.remove(0).toArray());
    }

    public void testSet() {
        assertArrayEquals(new Object[]{3, 35.9, 6}, list.set(2, 6).toArray());
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
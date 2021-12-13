package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

public class NodeTest extends TestCase {
    Node node1;

    public void setUp() throws Exception {
        super.setUp();
        node1 = new Node();
        node1.setValue("node1");
    }

    public void testTestToString() {
        assertEquals("node1", node1.toString());
    }

    public void testSetGetPrevious() {
        Node prev_node = new Node();
        prev_node.setValue("node0");

        node1.setPrevious(prev_node);
        assertEquals("node0", node1.getPrevious().getValue());
    }

    public void testSetGetValue() {
        node1.setValue("new_node1");
        assertEquals("new_node1", node1.getValue());
    }

    public void testSetGetNext() {
        Node next_node = new Node();
        next_node.setValue("node2");

        node1.setNext(next_node);
        assertEquals("node2", node1.getNext().getValue());
    }
}

package deque;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    private ArrayDeque<Integer> deque;

    @Before
    public void setup() {
        deque = new ArrayDeque<>();
    }

    @Test
    public void testAddFirst() {
        for (int i = 1; i <= 12; i++) {
            deque.addFirst(i);
            assertEquals(i, deque.size());
        }
    }

    @Test
    public void testAddLast() {
        for (int i = 1; i <= 9; i++) {
            deque.addLast(i);
            assertEquals(i, deque.size());
        }
    }

    @Test
    public void testRemoveFirst_singleElement() {
        deque.addFirst(1);
        assertEquals(1, (int) deque.removeFirst());
        assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveFirst_singleElementUsingAddLast() {
        deque.addLast(1);
        assertEquals(1, (int) deque.removeFirst());
        assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveFirstWithMultipleElements() {
        fillDeque();
        assertEquals(1, (int) deque.removeFirst());
        assertEquals(7, deque.size());
    }

    @Test
    public void testRemoveLast() {
        fillDeque();
        assertEquals(8, (int) deque.removeLast());
        assertEquals(7, deque.size());
    }

    @Test
    public void removeLast_addFirst() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);

        int actual = deque.removeLast();
        assertEquals(1, deque.size());
        assertEquals(1, actual);
    }

    @Test
    public void testGetWithValidIndex() {
        fillDeque();
        assertEquals(4, (int) deque.get(3));
    }

    @Test
    public void testGetWithEmptyDeque() {
        assertNull(deque.get(3));
    }

    @Test
    public void testGetWithInvalidIndex() {
        fillDeque();
        assertNull(deque.get(9));
    }

    @Test
    public void testIterator() {
        fillDeque();
        int expectedValue = 1;
        for (Integer value : deque) {
            assertEquals(expectedValue, (int) value);
            expectedValue++;
        }
    }

    @Test
    public void testEquals() {
        fillDeque();
        ArrayDeque<Integer> otherDeque = new ArrayDeque<>();
        for (int i = 1; i <= 8; i++) {
            otherDeque.addLast(i);
        }
        assertTrue(deque.equals(otherDeque));
    }

    private void fillDeque() {
        for (int i = 1; i <= 8; i++) {
            deque.addLast(i);
        }
    }

}
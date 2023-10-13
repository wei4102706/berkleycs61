package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addFirst() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        assertEquals(1, deque.size());

        deque.addFirst(2);
        assertEquals(2, deque.size());

        deque.addFirst(3);
        assertEquals(3, deque.size());

        deque.addFirst(4);
        assertEquals(4, deque.size());

        deque.addFirst(5);
        assertEquals(5, deque.size());

        deque.addFirst(6);
        assertEquals(6, deque.size());

        deque.addFirst(7);
        assertEquals(7, deque.size());

        deque.addFirst(8);
        assertEquals(8, deque.size());

        deque.addFirst(9);
        assertEquals(9, deque.size());

        deque.addFirst(10);
        assertEquals(10, deque.size());

        deque.addFirst(11);
        assertEquals(11, deque.size());

        deque.addFirst(12);
        assertEquals(12, deque.size());
    }



    @Test
    public void addLast() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        assertEquals(1, deque.size());

        deque.addLast(2);
        assertEquals(2, deque.size());

        deque.addLast(3);
        assertEquals(3, deque.size());

        deque.addLast(4);
        assertEquals(4, deque.size());

        deque.addLast(5);
        assertEquals(5, deque.size());

        deque.addLast(6);
        assertEquals(6, deque.size());

        deque.addLast(7);
        assertEquals(7, deque.size());

        deque.addLast(8);
        assertEquals(8, deque.size());

        deque.addLast(9);
        assertEquals(9, deque.size());
    }

    @Test
    public void removeFirst_firstEqLast() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        assertEquals(1, deque.size());

        int actual = deque.removeFirst();
        assertEquals(0, deque.size());
        assertEquals(1, actual);
    }

    @Test
    public void removeFirst_EmptyAdAddLast() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        assertEquals(1, deque.size());

        int actual = deque.removeFirst();
        assertEquals(0, deque.size());
        assertEquals(1, actual);
    }

    @Test
    public void removeFirst_fullAD() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);

        int actual = deque.removeFirst();
        assertEquals(7, deque.size());
        assertEquals(1, actual);
    }

    @Test
    public void removeLast_addLast() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);

        int actual = deque.removeLast();
        assertEquals(7, deque.size());
        assertEquals(8, actual);
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
    public void get_fullDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);

        int actual = deque.get(3);
        assertEquals(4, actual);
    }

    @Test
    public void get_emptyDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertNull( deque.get(3));
    }

    @Test
    public void get_invalidItem() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);

        assertNull( deque.get(9));
    }


}
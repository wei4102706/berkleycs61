package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private ListNode front;
    private ListNode back;
    private int size;

    private class ListNode<T> {
        T val;
        ListNode next;
        ListNode prev;

        public ListNode(T val) {
            this.val = val;
        }

        public ListNode() {
            this.val = null;
        }
    }

    /* Creates an empty linked list deque. */
    public LinkedListDeque() {
        front = new ListNode();
        back = new ListNode();
        front.next = back;
        back.prev = front;
        size = 0;
    }

    @Override
    public void addFirst(T val) {
        ListNode node = new ListNode(val); // node to add
        node.next = front.next;
        front.next.prev = node;
        front.next = node;
        node.prev = front;
        size++;
    }

    @Override
    /* Adds an item of type T to the back of the deque. */
    public void addLast(T val) {
        ListNode node = new ListNode(val);
        node.prev = back.prev;
        back.prev.next = node;
        back.prev = node;
        node.next = back;
        size++;
    }

    /* Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    @Override
    public void printDeque() {
        ListNode node = front;
        while (node != null && node.next != back) {
            node = node.next;
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    /* Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        ListNode node = front.next;
        front.next = node.next;
        node.next.prev = front;
        node.prev = null;
        node.next = null;
        size--;

        return (T) node.val;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        ListNode node = back.prev;
        back.prev = node.prev;
        node.prev.next = back;
        node.next = null;
        node.prev = null;
        size--;

        return (T) node.val;
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     */
    @Override
    public T get(int index) {
        ListNode node = front;
        int count = 0;

        while (node != null && node.next != back) {
            node = node.next;
            if (count == index) {
                return (T) node.val;
            }
            count++;
        }

        return null;
    }

    /* Same as get, but uses recursion. */
    public T getRecursive(int index) {
        return (T) recursiveHelper(front.next, index);
    }

    private T recursiveHelper(ListNode ptr, int count) {
        if (ptr == null || count < 0) {
            return null;
        }
        if (count == 0) {
            return (T) ptr.val;
        }
        return (T) recursiveHelper(ptr.next, count - 1);
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedListDeque)) return false;
        ListNode a = front;
        ListNode b = ((LinkedListDeque) o).front;
        while (a != null || b != null) {
            if (a == null || b == null || !a.val.equals(b.val)) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return true;
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        ListNode current;

        public LinkedListDequeIterator() {
            this.current = front.next;
        }

        @Override
        public boolean hasNext() {
            return current != back;
        }

        @Override
        public T next() {
            T item = (T) current.val;
            current = current.next;
            return item;
        }
    }
}

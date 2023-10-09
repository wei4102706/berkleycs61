package deque;

public class LinkedListDeque<T> {
    ListNode front;
    ListNode back;
    int size;

    public class ListNode<T> {
        T val;
        ListNode next;
        ListNode prev;

        public ListNode(T val) {
            this.val = val;
        }
    }

    /* Creates an empty linked list deque. */
    public LinkedListDeque() {
        front = new ListNode(0);
        back = new ListNode(100);
        front.next = back;
        back.prev = front;
        size = 0;
    }

    public void addFirst(T val) {
        ListNode node = new ListNode(val); // node to add
        node.next = front.next;
        front.next.prev = node;
        front.next = node;
        node.prev = front;
        size++;
    }

    /* Adds an item of type T to the back of the deque. */
    public void addLast(T val) {
        ListNode node = new ListNode(val);
        node.prev = back.prev;
        back.prev.next = node;
        back.prev = node;
        node.next = back;
        size++;
    }

    /* Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        ListNode node = front;
        while(node != null && node.next != back) {
            node = node.next;
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    /* Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
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
    public T get(int index) {
        ListNode node = front;
        int count = 0;

        while (node != null && node.next != back) {
            node = node.next;
            if ( count == index) {
                return (T) node.val;
            }
        }

        return null;
    }

    /* Same as get, but uses recursion. */
    public T getRecursive(int index) {
        return recursiveHelper(front, index);
    }

    private T recursiveHelper(ListNode ptr, int count) {
        if(count == 0){
            return (T) ptr.val;
        }
         ptr = ptr.next;
        return recursiveHelper(ptr, count - 1);
    }
}

package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private static final int INITIAL_CAPACITY = 8;
    private T[] items;
    private int size;
    private int front;
    private int back;

    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        front = INITIAL_CAPACITY / 2;
        back = INITIAL_CAPACITY / 2;
    }

    @Override
    public void addFirst(T item) {
        if (size >= items.length) {
            resize(size * 2);
        }

        front = (front == 0) ? items.length - 1 : front - 1;
        items[front] = item;
        size++;
        if (size == 1) {
            back = front;
        }
    }

    @Override
    public void addLast(T item) {
        if (size >= items.length) {
            resize(size * 2);
        }

        back = (back == items.length - 1) ? 0 : back + 1;
        items[back] = item;
        size++;
        if (size == 1) {
            front = back;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int count = 0;
        int i = front;
        while (count < size) {
            System.out.print(items[i] + " ");
            i = (i + 1) % items.length;
            count++;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = items[front];
        items[front] = null;
        front = (front == items.length - 1) ? 0 : front + 1;
        size--;
        maybeResize();
        return item;
    }

    private void maybeResize() {
        if (size <= items.length / 4 && items.length >= 16) {
            resize(items.length / 2);
        }
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item = items[back];
        items[back] = null;
        back = (back == 0) ? items.length - 1 : back - 1;
        size--;
        maybeResize();
        return item;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }

        int i = (front + index) % items.length;
        return items[i];
    }

    private void resize(int capacity) {
        T[] newArr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = get(i);
        }
        front = 0;
        back = size - 1;
        items = newArr;
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayDeque)) return false;
        ArrayDeque<?> that = (ArrayDeque<?>) o;
        for (int i = 0; i < size; i++) {
            if (!this.get(i).equals(that.get(i))) {
                return false;
            }
        }
        return true;
    }

    private class ArrayDequeIterator implements Iterator<T> {
        int index;

        public ArrayDequeIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T item = (T) get(index);
            index++;
            return item;
        }
    }
}

package deque;

import java.util.Arrays;
import java.util.Iterator;

import static java.lang.System.arraycopy;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
     private T[] items;
    private int size;
    private int front;
    private int back;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 4;
        back = 4;
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

        back = (back == items.length - 1)? 0 : back + 1;

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
        for (int i = front; count < size; i = (i + 1) % items.length) {
            System.out.print(items[i] + " ");
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
        if (front == items.length - 1) {
            front = 0;
        } else {
            front++;
        }
        size--;

        if(size <= items.length / 4 && items.length >= 16) {
            resize(items.length / 2);
        }

        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T item = items[back];
        items[back] = null;
        if (back == 0) {
            back = items.length - 1;
        } else {
            back--;
        }
        size--;

        if(size <= items.length / 4 && items.length >= 16) {
            resize(items.length / 2);
        }

        return item;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }

        int i = front + index;
        if (i >= items.length) {
            i = i - items.length;
        }
        return items[i];
    }

    private void resize(int capacity) {
        T[] newArr = (T[]) new Object[capacity];

        if (front < back) {
            arraycopy(items, front, newArr, 0, size);
        } else {
            arraycopy(items, front, newArr, 0, items.length - front);
            arraycopy(items, 0, newArr, items.length - front, back + 1);
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
        return Arrays.equals(items, ((ArrayDeque) o).items);
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

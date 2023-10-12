package deque;

import static java.lang.System.arraycopy;

public class ArrayDeque<T> implements Deque<T> {
    T[] items;
    int size;
    int front;
    int back;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 4;
        back = 4;
    }

    @Override
    public void addFirst(T item) {
        if (size > items.length) resize(size * 2);

        if (front == 0) {
            front = items.length - 1;
        } else {
            front--;
        }

        items[front] = item;
        size++;
        if (size == 1) {
            back = front;
        }
    }

    @Override
    public void addLast(T item) {
        if (size > items.length) {
            resize(size * 2);
        }

        if (back == items.length - 1) {
            back = 0;
        } else {
            back++;
        }

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
        for (int i = front; count < size; i++) {
            if (i == items.length) {
                i = 0;
            }
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
    }
}

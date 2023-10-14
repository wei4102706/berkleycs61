package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> c;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.c = c;
    }

    // Returns the maximum element in the deque as determined by the previously
    public T max() {
        return max(c);
    }

    public T max(Comparator<T> comparator) {
        this.c = comparator;
        if (size() == 0) {
            return null;
        }
        if (size() == 1) {
            return get(0);
        }

        T max = get(0);
        for (int i = 1; i < size(); i++) {
            if (comparator.compare(max, get(i)) < 0) {
                max = get(i);
            }
        }
        return max;
    }
}

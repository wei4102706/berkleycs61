package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    Comparator<T> c;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.c = c;
    }

    public T max() {
        if (size() == 0) return null;
        if (size() == 1) return super.get(0);
        T max = (T) super.get(0);
        for (int i = 1; i < size(); i++) {
            if (c.compare(max, super.get(i)) < 0) {
                max = (T) super.get(i);
            }
        }
        return max;
    }

    public T max(Comparator<T> c) {
        if (size() == 0) return null;
        this.c = c;
        return max();
    }
}

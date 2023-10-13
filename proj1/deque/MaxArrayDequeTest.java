package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {

    @Test
    public void max() {
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
        MaxArrayDeque<String> test = new MaxArrayDeque<>(lengthComparator);
        test.addLast("a");
        test.addLast("bb");
        test.addLast("ccc");
        test.addLast("dddd");
        String expected = "dddd";
        String actual = test.max();
        assertEquals(expected, actual);
    }

    @Test
    public void maxWithInputComparator() {
        class BitCountComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                int bitsCount1 = Integer.bitCount(o1);
                int bitsCount2 = Integer.bitCount(o2);
                return Integer.compare(bitsCount2, bitsCount1);
            }
        }
        Comparator<Integer> bitCount = new BitCountComparator();
        Comparator<Integer> naturalOrder = Comparator.naturalOrder();

        MaxArrayDeque<Integer> test = new MaxArrayDeque<>(naturalOrder);
        test.addLast(1);
        test.addLast(111);
        test.addLast(11111);
        test.addLast(111111);
        Integer expected = 1;
        Integer actual = test.max(bitCount);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxArrayDequeEquals() {
        Comparator<Integer> comparator = Integer::compareTo;
        MaxArrayDeque<Integer> mad1 = new MaxArrayDeque<>(comparator);
        MaxArrayDeque<Integer> mad2 = new MaxArrayDeque<>(comparator);

        mad1.addFirst(1);
        mad1.addLast(2);
        mad2.addFirst(1);
        mad2.addLast(2);
        assertTrue(mad1.equals(mad2));

        mad2.removeLast();
        assertFalse(mad1.equals(mad2));
    }
}
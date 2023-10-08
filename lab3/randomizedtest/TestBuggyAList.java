package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> expected = new AListNoResizing<>();
        expected.addLast(4);
        expected.addLast(5);
        expected.addLast(6);

        BuggyAList<Integer> actual = new BuggyAList<>();
        actual.addLast(4);
        actual.addLast(5);
        actual.addLast(6);

        assertEquals(expected.size(), actual.size());

        assertEquals(expected.removeLast(), actual.removeLast());
        assertEquals(expected.removeLast(), actual.removeLast());
        assertEquals(expected.removeLast(), actual.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                assertEquals(L.getLast(), B.getLast());
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeB = B.size();
                assertEquals(size, sizeB);
            } else if (operationNumber == 2) {
                if (L.size() > 0) {
                    int value = L.getLast();
                    int valueB = B.getLast();
                    assertEquals(value, valueB);
                }
            } else if (operationNumber == 3) {
                if (L.size() > 0) {
                    int value = L.removeLast();
                    int valueB = B.removeLast();
                    assertEquals(value, valueB);
                }
            }
        }
    }
}

package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

import java.util.ArrayList;

public class TestArrayDequeEC {

    private String operationToString(ArrayList<String> operations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < operations.size(); i++) {
            sb.append(operations.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    @Test
    public void studentADRandomizedTest() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        ArrayList<String> operations = new ArrayList<>();

        int N = 5000;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                student.addFirst(i);
                solution.addFirst(i);
                operations.add("addFirst(" + i + ")");
                Integer actual = student.get(0);
                Integer expected = solution.get(0);
                assertEquals(operationToString(operations), expected, actual);
            } else if (operationNumber == 1) {
                student.addLast(i);
                solution.addLast(i);
                operations.add("addLast(" + i + ")");
                Integer actual = student.get(student.size() - 1);
                Integer expected = solution.get(solution.size() - 1);
                assertEquals(operationToString(operations) + actual, expected, actual);
            } else if (operationNumber == 2) {
                if (student.size() > 0) {
                    operations.add("removeFirst()");
                    Integer actual = student.removeFirst();
                    Integer expected = solution.removeFirst();
                    assertEquals(operationToString(operations), expected, actual);
                }
            } else if (operationNumber == 3) {
                if (student.size() > 0) {
                    operations.add("removeLast()");
                    Integer actual = student.removeLast();
                    Integer expected = solution.removeLast();
                    assertEquals(operationToString(operations), expected, actual);
                }
            } else if (operationNumber == 4) {
                if (student.size() > 0) {
                    int index = StdRandom.uniform(0, student.size());
                    operations.add("get(" + index + ")");
                    Integer actual = student.get(index);
                    Integer expected = solution.get(index);
                    assertEquals(operationToString(operations), expected, actual);
                }
            } else if (operationNumber == 5) {
                operations.add("size()");
                Integer actual = student.size();
                Integer expected = solution.size();
                assertEquals(operationToString(operations), expected, actual);
            }
        }

    }
}

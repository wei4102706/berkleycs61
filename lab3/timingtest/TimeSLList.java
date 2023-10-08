package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int maxN = 128000;
        AList<Integer> Ns = new AList<>();
        for(int i = 1000; i <= maxN; i *= 2){
            Ns.addLast(i);
        }
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for(int i = 0; i < Ns.size(); i++){
            opCounts.addLast(10000);
        }

        for(int i = 0; i < Ns.size(); i++){
            // Create a SLList of size N
            SLList<Integer> test = new SLList<>();

            // Add N items to the SLList
            for(int j = 0; j < Ns.get(i); j++){
                test.addLast(j);
            }

            // Start timing
            Stopwatch sw = new Stopwatch();

            // Perform 10000 getLast operations on the SLList.
            for(int j = 0; j < opCounts.get(i); j++){
                test.getLast();
            }

            // Check the timer. This gives the total time to complete all M operations.
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, opCounts);
    }

}

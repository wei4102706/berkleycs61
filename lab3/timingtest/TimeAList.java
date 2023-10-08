package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    /** Times how long it takes to call getLast. */
    public static void timeAListConstruction() {
        // Done: YOUR CODE HERE
        int maxN = 128000;
//        int maxN = 1000000;
        AList<Integer> Ns = new AList<>();
        for(int i = 1000; i <= maxN; i *= 2){
            Ns.addLast(i);
        }
        AList<Double> times = new AList<>();

        for(int j = 0; j < Ns.size(); j++){
            AList<Integer> test = new AList<>();
            // Start timing
            Stopwatch sw = new Stopwatch();
            for(int i = 0; i < Ns.get(j); i++){
                test.addLast(i);
            }
            // Stop timing
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, Ns);
    }
}

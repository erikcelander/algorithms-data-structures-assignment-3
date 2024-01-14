package uppgift.uppgift1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class BenchmarkQuickSort {

    private static final Random random = new Random();

    private static List<Integer> createRandomData(int count) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            data.add(random.nextInt(100000));
        }
        return data;
    }

    private static TimeIt.TimingResult runSorting(List<Integer> data, int depth, int repetitions) throws Exception {
        QuickSort sorter = new QuickSort();
        Callable<Void> sortTask = () -> {
            sorter.sort(new ArrayList<>(data), depth);
            return null;
        };
        return TimeIt.timeIt(sortTask, repetitions);
    }

    public static void main(String[] args) {
        int[] dataSetSizes = new int[] {1999, 4001, 7993, 16001, 32003};
        int maxDepth = 30;
        int repetitions = 30;
        String resultFilePath = "benchmark_results.csv";

        try (FileWriter writer = new FileWriter(resultFilePath)) {
            // Write the header
            writer.write("Depth,");
            for (int size : dataSetSizes) {
                writer.write(size + ",");
            }
            writer.write("\n");

            // Write results in a matrix format
            for (int depth = 0; depth <= maxDepth; depth++) {
                writer.write(depth + ",");
                for (int size : dataSetSizes) {
                    List<Integer> data = createRandomData(size);
                    try {
                        TimeIt.TimingResult result = runSorting(data, depth, repetitions);
                        writer.write(result.median + ",");
                    } catch (Exception e) {
                        System.err.println("An error occurred while running the benchmark: " + e.getMessage());
                        writer.write("ERROR,");
                    }
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    
    // QuickSort class and TimeIt class are assumed to be implemented elsewhere in the package.
}

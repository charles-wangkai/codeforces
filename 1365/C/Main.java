import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = readArray(sc, n);
        int[] b = readArray(sc, n);

        System.out.println(solve(a, b));

        sc.close();
    }

    static int[] readArray(Scanner sc, int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = sc.nextInt();
        }

        return result;
    }

    static int solve(int[] a, int[] b) {
        int n = a.length;

        int[] aIndices = buildIndices(a);
        int[] bIndices = buildIndices(b);

        Map<Integer, Integer> indexDiffToCount = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int indexDiff = (bIndices[i] - aIndices[i] + n) % n;

            indexDiffToCount.put(indexDiff, indexDiffToCount.getOrDefault(indexDiff, 0) + 1);
        }

        return indexDiffToCount.values().stream().mapToInt(x -> x).max().getAsInt();
    }

    static int[] buildIndices(int[] values) {
        int[] indices = new int[values.length];
        for (int i = 0; i < values.length; ++i) {
            indices[values[i] - 1] = i;
        }

        return indices;
    }
}
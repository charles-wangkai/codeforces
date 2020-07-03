import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int q = sc.nextInt();
            long[] l = new long[q];
            long[] r = new long[q];
            for (int i = 0; i < q; ++i) {
                l[i] = sc.nextLong();
                r[i] = sc.nextLong();
            }

            System.out.println(solve(a, b, l, r));
        }

        sc.close();
    }

    static String solve(int a, int b, long[] l, long[] r) {
        int prefixSum = 0;
        int[] prefixSums = new int[a * b];
        for (int i = 0; i < prefixSums.length; ++i) {
            if (i % a % b != i % b % a) {
                ++prefixSum;
            }

            prefixSums[i] = prefixSum;
        }

        return IntStream.range(0, l.length).mapToObj(i -> String.valueOf(query(prefixSums, l[i], r[i])))
                .collect(Collectors.joining(" "));
    }

    static long query(int[] prefixSums, long left, long right) {
        return computePrefixSum(prefixSums, right + 1) - computePrefixSum(prefixSums, left);
    }

    static long computePrefixSum(int[] prefixSums, long end) {
        return end / prefixSums.length * prefixSums[prefixSums.length - 1]
                + ((end % prefixSums.length != 0) ? (prefixSums[(int) (end % prefixSums.length) - 1]) : 0);
    }
}
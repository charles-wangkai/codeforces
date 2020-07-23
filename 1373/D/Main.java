import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a));
        }

        sc.close();
    }

    static long solve(int[] a) {
        return IntStream.range(0, a.length).filter(i -> i % 2 == 0).map(i -> a[i]).asLongStream().sum() + Math.max(
                computeMaxSubArraySum(
                        IntStream.range(2, a.length).filter(i -> i % 2 == 0).map(i -> a[i - 1] - a[i]).toArray()),
                computeMaxSubArraySum(IntStream.range(0, a.length).filter(i -> i % 2 == 0 && i + 1 < a.length)
                        .map(i -> a[i + 1] - a[i]).toArray()));
    }

    static long computeMaxSubArraySum(int[] values) {
        long result = 0;
        long sum = 0;
        for (int value : values) {
            sum += value;
            result = Math.max(result, sum);
            sum = Math.max(0, sum);
        }

        return result;
    }
}
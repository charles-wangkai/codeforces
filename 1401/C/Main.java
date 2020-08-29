import java.util.Arrays;
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

            System.out.println(solve(a) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(int[] a) {
        int min = Arrays.stream(a).min().getAsInt();
        int[] sortedMultiples = Arrays.stream(a).filter(x -> x % min == 0).boxed().sorted().mapToInt(x -> x).toArray();

        int sortedMultipleIndex = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] % min == 0) {
                a[i] = sortedMultiples[sortedMultipleIndex];
                ++sortedMultipleIndex;
            }
        }

        return IntStream.range(0, a.length - 1).allMatch(i -> a[i] <= a[i + 1]);
    }
}
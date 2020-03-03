import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static final int[][] SETS = { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 }, { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 },
            { 1, 1, 1 } };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            System.out.println(solve(a, b, c));
        }

        sc.close();
    }

    static int solve(int a, int b, int c) {
        int[] counts = IntStream.of(a, b, c).sorted().toArray();

        int result = 0;
        for (int[] set : SETS) {
            if (IntStream.range(0, counts.length).allMatch(i -> counts[i] >= set[i])) {
                for (int i = 0; i < counts.length; ++i) {
                    counts[i] -= set[i];
                }

                ++result;
            }
        }

        return result;
    }
}
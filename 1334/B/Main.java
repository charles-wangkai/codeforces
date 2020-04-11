import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a, x));
        }

        sc.close();
    }

    static int solve(int[] a, int x) {
        int[] sorted = Arrays.stream(a).boxed().sorted(Collections.reverseOrder()).mapToInt(ai -> ai).toArray();

        long sum = 0;
        for (int i = 0; i < sorted.length; ++i) {
            sum += sorted[i];

            if (sum < (long) x * (i + 1)) {
                return i;
            }
        }

        return a.length;
    }
}
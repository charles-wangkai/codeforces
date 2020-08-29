import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a, k));
        }

        sc.close();
    }

    static String solve(int[] a, long k) {
        if (k >= 3) {
            k = (k % 2 == 0) ? 2 : 1;
        }

        for (int i = 0; i < k; ++i) {
            int max = Arrays.stream(a).max().getAsInt();

            for (int j = 0; j < a.length; ++j) {
                a[j] = max - a[j];
            }
        }

        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
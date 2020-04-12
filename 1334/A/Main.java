import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            int n = sc.nextInt();
            int[] p = new int[n];
            int[] c = new int[n];
            for (int i = 0; i < n; ++i) {
                p[i] = sc.nextInt();
                c[i] = sc.nextInt();
            }

            System.out.println(solve(p, c) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(int[] p, int[] c) {
        return p[0] >= c[0] && IntStream.range(0, p.length - 1)
                .allMatch(i -> p[i] <= p[i + 1] && c[i] <= c[i + 1] && p[i + 1] - p[i] >= c[i + 1] - c[i]);
    }
}
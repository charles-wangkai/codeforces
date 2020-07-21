import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    a[i][j] = sc.nextInt();
                }
            }

            System.out.println(solve(a));
        }

        sc.close();
    }

    static int solve(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        int half = (n + m - 1) / 2;
        int[][] counts = new int[half][2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int minDistance = Math.min(i + j, n + m - i - j - 2);
                if (minDistance < half) {
                    ++counts[minDistance][a[i][j]];
                }
            }
        }

        return Arrays.stream(counts).mapToInt(c -> Arrays.stream(c).min().getAsInt()).sum();
    }
}
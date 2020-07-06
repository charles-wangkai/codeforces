import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static final int[] R_OFFSETS = { -1, 0, 1, 0 };
    static final int[] C_OFFSETS = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n][m];
            for (int r = 0; r < n; ++r) {
                for (int c = 0; c < m; ++c) {
                    a[r][c] = sc.nextInt();
                }
            }

            System.out.println(solve(a));
        }

        sc.close();
    }

    static String solve(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        int[][] result = new int[n][m];
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < m; ++c) {
                for (int i = 0; i < R_OFFSETS.length; ++i) {
                    int adjR = r + R_OFFSETS[i];
                    int adjC = c + C_OFFSETS[i];

                    if (adjR >= 0 && adjR < n && adjC >= 0 && adjC < m) {
                        ++result[r][c];
                    }
                }

                if (result[r][c] < a[r][c]) {
                    return "NO";
                }
            }
        }

        return String.format("YES\n%s",
                Arrays.stream(result)
                        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                        .collect(Collectors.joining("\n")));
    }
}
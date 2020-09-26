import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a, x));

        sc.close();
    }

    static String solve(int[] a, int x) {
        int n = a.length;

        boolean[][] leftSums = new boolean[n][x + 1];
        leftSums[0][0] = true;
        for (int i = 1; i <= n - 1; ++i) {
            for (int j = 0; j <= x; ++j) {
                leftSums[i][j] = leftSums[i - 1][j] || (j >= a[i - 1] && leftSums[i - 1][j - a[i - 1]]);
            }
        }

        boolean[][] rightSums = new boolean[n + 2][x + 1];
        rightSums[n + 1][0] = true;
        for (int i = n; i >= 2; --i) {
            for (int j = 0; j <= x; ++j) {
                rightSums[i][j] = rightSums[i + 1][j] || (j >= a[i - 1] && rightSums[i + 1][j - a[i - 1]]);
            }
        }

        List<Integer> necessities = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            boolean found = false;
            for (int j = 0; j <= x; ++j) {
                if (leftSums[i][j] && x >= j && rightSums[i + 2][x - j]) {
                    found = true;
                }
            }

            if (!found) {
                necessities.add(a[i]);
            }
        }

        return String.format("%d\n%s", necessities.size(),
                necessities.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
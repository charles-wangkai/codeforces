import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            System.out.println(solve(n, k));
        }

        sc.close();
    }

    static String solve(int n, int k) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; ++i) {
            int r = 0;
            int c = i;
            for (int j = 0; j < n; ++j) {
                if (k != 0) {
                    grid[r][c] = 1;
                    --k;
                } else {
                    grid[r][c] = 0;
                }

                ++r;
                c = (c + 1) % n;
            }
        }

        int[] rowSums = new int[n];
        int[] colSums = new int[n];
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                rowSums[r] += grid[r][c];
                colSums[c] += grid[r][c];
            }
        }

        int minRowSum = Arrays.stream(rowSums).min().getAsInt();
        int maxRowSum = Arrays.stream(rowSums).max().getAsInt();
        int minColSum = Arrays.stream(colSums).min().getAsInt();
        int maxColSum = Arrays.stream(colSums).max().getAsInt();
        int fA = (maxRowSum - minRowSum) * (maxRowSum - minRowSum) + (maxColSum - minColSum) * (maxColSum - minColSum);

        return String.format("%d\n%s", fA,
                Arrays.stream(grid)
                        .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining()))
                        .collect(Collectors.joining("\n")));
    }
}
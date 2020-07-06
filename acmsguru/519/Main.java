import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] heights = new int[n][m];
        for (int r = 0; r < n; ++r) {
            String line = sc.next();
            for (int c = 0; c < m; ++c) {
                heights[r][c] = line.charAt(c) - '0';
            }
        }

        System.out.println(solve(heights));

        sc.close();
    }

    static int solve(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int result = 0;
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < m; ++c) {
                for (int h = 1; h <= heights[r][c]; ++h) {
                    if (h == 1) {
                        ++result;
                    }
                    if (h == heights[r][c]) {
                        ++result;
                    }
                    if (r == 0 || heights[r - 1][c] < h) {
                        ++result;
                    }
                    if (r == n - 1 || heights[r + 1][c] < h) {
                        ++result;
                    }
                    if (c == 0 || heights[r][c - 1] < h) {
                        ++result;
                    }
                    if (c == m - 1 || heights[r][c + 1] < h) {
                        ++result;
                    }
                }
            }
        }

        return result;
    }
}
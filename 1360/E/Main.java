import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            for (int r = 0; r < n; ++r) {
                String line = sc.next();
                for (int c = 0; c < n; ++c) {
                    matrix[r][c] = line.charAt(c) - '0';
                }
            }

            System.out.println(solve(matrix) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(int[][] matrix) {
        int n = matrix.length;

        for (int r = 0; r < n - 1; ++r) {
            for (int c = 0; c < n - 1; ++c) {
                if (matrix[r][c] == 1 && matrix[r][c + 1] == 0 && matrix[r + 1][c] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
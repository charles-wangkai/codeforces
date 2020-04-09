import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println(solve(n, m));
        }

        sc.close();
    }

    static String solve(int n, int m) {
        char[][] result = new char[n][m];
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < m; ++c) {
                result[r][c] = ((r + c) % 2 == 0) ? 'B' : 'W';
            }
        }

        if (n * m % 2 == 0) {
            if (n != 1) {
                result[1][0] = 'B';
            } else {
                result[0][1] = 'B';
            }
        }

        return Arrays.stream(result).map(String::new).collect(Collectors.joining("\n"));
    }
}
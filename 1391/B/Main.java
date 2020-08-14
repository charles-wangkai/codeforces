import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] a = new char[n][m];
            for (int r = 0; r < n; ++r) {
                String line = sc.next();
                for (int c = 0; c < m; ++c) {
                    a[r][c] = line.charAt(c);
                }
            }

            System.out.println(solve(a));
        }

        sc.close();
    }

    static int solve(char[][] a) {
        int n = a.length;
        int m = a[0].length;

        return (int) (IntStream.range(0, m - 1).filter(c -> a[n - 1][c] == 'D').count()
                + IntStream.range(0, n - 1).filter(r -> a[r][m - 1] == 'R').count());
    }
}
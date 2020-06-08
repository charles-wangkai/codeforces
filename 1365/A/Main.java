import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
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

        int emptyRowNum = (int) IntStream.range(0, n).filter(r -> IntStream.range(0, m).allMatch(c -> a[r][c] == 0))
                .count();
        int emptyColNum = (int) IntStream.range(0, m).filter(c -> IntStream.range(0, n).allMatch(r -> a[r][c] == 0))
                .count();

        return (Math.min(emptyRowNum, emptyColNum) % 2 != 0) ? "Ashish" : "Vivek";
    }
}
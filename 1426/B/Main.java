import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][][] tiles = new int[n][2][2];
            for (int i = 0; i < n; ++i) {
                for (int r = 0; r < 2; ++r) {
                    for (int c = 0; c < 2; ++c) {
                        tiles[i][r][c] = sc.nextInt();
                    }
                }
            }

            System.out.println(solve(tiles, m) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(int[][][] tiles, int m) {
        return m % 2 == 0 && Arrays.stream(tiles).anyMatch(tile -> tile[0][1] == tile[1][0]);
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int sx = sc.nextInt() - 1;
        int sy = sc.nextInt() - 1;

        System.out.println(solve(n, m, sx, sy));

        sc.close();
    }

    static String solve(int n, int m, int sx, int sy) {
        boolean[][] visited = new boolean[n][m];

        List<String> result = new ArrayList<>();
        int r = sx;
        int c = sy;
        visited[r][c] = true;
        result.add(String.format("%d %d", r + 1, c + 1));

        r = 0;
        visited[r][c] = true;
        result.add(String.format("%d %d", r + 1, c + 1));

        c = 0;

        int offsetC = 1;
        while (r != n) {
            if (!visited[r][c]) {
                visited[r][c] = true;
                result.add(String.format("%d %d", r + 1, c + 1));
            }

            c += offsetC;
            if (c == -1 || c == m) {
                ++r;
                offsetC *= -1;
                c += offsetC;
            }
        }

        return String.join("\n", result);
    }
}
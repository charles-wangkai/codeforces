import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] sx = new int[k];
        int[] sy = new int[k];
        for (int i = 0; i < k; ++i) {
            sx[i] = sc.nextInt();
            sy[i] = sc.nextInt();
        }
        int[] fx = new int[k];
        int[] fy = new int[k];
        for (int i = 0; i < k; ++i) {
            fx[i] = sc.nextInt();
            fy[i] = sc.nextInt();
        }

        System.out.println(solve(n, m, sx, sy, fx, fy));

        sc.close();
    }

    static String solve(int n, int m, int[] sx, int[] sy, int[] fx, int[] fy) {
        StringBuilder operations = new StringBuilder();
        for (int i = 0; i < m - 1; ++i) {
            operations.append('L');
        }
        for (int i = 0; i < n - 1; ++i) {
            operations.append('U');
        }

        int x = 0;
        int y = 0;
        int yOffset = 1;
        while (x != n) {
            if ((y == 0 && yOffset == -1) || (y == m - 1 && yOffset == 1)) {
                operations.append('D');
                ++x;
                yOffset *= -1;
            } else {
                if (yOffset == 1) {
                    operations.append('R');
                    ++y;
                } else {
                    operations.append('L');
                    --y;
                }
            }
        }

        return String.format("%d\n%s", operations.length(), operations);
    }
}
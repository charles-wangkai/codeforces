import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            sc.nextInt();
            String s = sc.next();

            System.out.println(solve(s));
        }

        sc.close();
    }

    static int solve(String s) {
        int n = s.length();
        int logn = Integer.toBinaryString(n).length() - 1;
        int[][][] moveNums = new int[logn + 1][][];
        int[][][] counts = new int[logn + 1][][];
        for (int i = 0; i <= logn; ++i) {
            int step = 1 << i;

            moveNums[i] = new int[n / step][logn + 1];
            counts[i] = new int[n / step][logn + 1];
        }

        for (int i = 0; i <= logn; ++i) {
            int step = 1 << i;
            for (int j = 0; j < moveNums[i].length; ++j) {
                int value = s.charAt(step * j) - 'a';
                for (int k = 0; k <= logn; ++k) {
                    if (i == 0) {
                        moveNums[i][j][k] = (value == k) ? 0 : 1;

                        if (value == k) {
                            ++counts[i][j][k];
                        }
                    } else {
                        if (k != logn) {
                            moveNums[i][j][k] = Math.min(
                                    (step / 2 - counts[i - 1][2 * j][k]) + moveNums[i - 1][2 * j + 1][k + 1],
                                    moveNums[i - 1][2 * j][k + 1] + (step / 2 - counts[i - 1][2 * j + 1][k]));
                        }

                        counts[i][j][k] = counts[i - 1][2 * j][k] + counts[i - 1][2 * j + 1][k];
                    }
                }
            }
        }

        return moveNums[logn][0][0];
    }
}
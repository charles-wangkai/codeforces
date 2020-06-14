import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int x = sc.nextInt() - 1;
            int m = sc.nextInt();
            int[] l = new int[m];
            int[] r = new int[m];
            for (int i = 0; i < m; ++i) {
                l[i] = sc.nextInt() - 1;
                r[i] = sc.nextInt() - 1;
            }

            System.out.println(solve(n, x, l, r));
        }

        sc.close();
    }

    static int solve(int n, int x, int[] l, int[] r) {
        int minIndex = x;
        int maxIndex = x;
        for (int i = 0; i < l.length; ++i) {
            if (!(l[i] > maxIndex || r[i] < minIndex)) {
                minIndex = Math.min(minIndex, l[i]);
                maxIndex = Math.max(maxIndex, r[i]);
            }
        }

        return maxIndex - minIndex + 1;
    }
}
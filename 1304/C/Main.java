import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        for (int tc = 0; tc < q; ++tc) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] t = new int[n];
            int[] l = new int[n];
            int[] h = new int[n];
            for (int i = 0; i < n; ++i) {
                t[i] = sc.nextInt();
                l[i] = sc.nextInt();
                h[i] = sc.nextInt();
            }

            System.out.println(solve(t, l, h, m) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(int[] t, int[] l, int[] h, int m) {
        int lower = m;
        int upper = m;
        for (int i = 0; i < t.length; ++i) {
            int delta = t[i] - (i == 0 ? 0 : t[i - 1]);

            int nextLower = Math.max(lower - delta, l[i]);
            int nextUpper = Math.min(upper + delta, h[i]);
            if (nextLower > nextUpper) {
                return false;
            }

            lower = nextLower;
            upper = nextUpper;
        }

        return true;
    }
}
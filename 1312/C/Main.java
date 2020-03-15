import java.util.Scanner;

public class Main {
    static final int SIZE = 60;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextLong();
            }

            System.out.println(solve(a, k) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(long[] a, int k) {
        boolean[] ones = new boolean[SIZE];
        for (long ai : a) {
            for (int i = 0; i < ones.length; ++i) {
                int digit = (int) (ai % k);
                if (digit >= 2 || (digit == 1 && ones[i])) {
                    return false;
                } else if (digit == 1) {
                    ones[i] = true;
                }

                ai /= k;
            }
        }

        return true;
    }
}
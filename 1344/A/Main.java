import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(int[] a) {
        int n = a.length;

        boolean[] used = new boolean[n];
        for (int i = 0; i < a.length; ++i) {
            int index = ((i + a[i]) % n + n) % n;
            if (used[index]) {
                return false;
            }

            used[index] = true;
        }

        return true;
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < p.length; ++i) {
                p[i] = sc.nextInt();
            }

            System.out.println(solve(p) ? "Yes" : "No");
        }

        sc.close();
    }

    static boolean solve(int[] p) {
        int n = p.length;
        int[] indices = new int[n + 1];
        for (int i = 0; i < p.length; ++i) {
            indices[p[i]] = i;
        }

        int prevIndex = -1;
        for (int i = 1; i <= n; ++i) {
            if (prevIndex != -1 && prevIndex != n - 1 && p[prevIndex + 1] > i) {
                return false;
            }

            prevIndex = indices[i];
        }

        return true;
    }
}
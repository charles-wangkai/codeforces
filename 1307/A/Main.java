import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a, d));
        }

        sc.close();
    }

    static int solve(int[] a, int d) {
        int result = a[0];
        for (int i = 1; i < a.length; ++i) {
            int additive = Math.min(a[i], d / i);
            result += additive;
            d -= additive * i;
        }

        return result;
    }
}
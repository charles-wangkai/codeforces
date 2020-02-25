import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a, x));
        }

        sc.close();
    }

    static int solve(int[] a, int x) {
        if (Arrays.stream(a).anyMatch(ai -> ai == x)) {
            return 1;
        }

        return Math.max(2, divideToCeil(x, Arrays.stream(a).max().getAsInt()));
    }

    static int divideToCeil(int p, int q) {
        return p / q + (p % q == 0 ? 0 : 1);
    }
}
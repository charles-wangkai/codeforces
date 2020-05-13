import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            System.out.println(solve(n, k));
        }

        sc.close();
    }

    static int solve(int n, int k) {
        return n + f(n) + (k - 1) * 2;
    }

    static int f(int n) {
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return i;
            }
        }

        return n;
    }
}
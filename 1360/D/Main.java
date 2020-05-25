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
        int result = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n && i <= k; ++i) {
            if (n % i == 0) {
                result = Math.min(result, n / i);

                if (n / i <= k) {
                    result = Math.min(result, i);
                }
            }
        }

        return result;
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(solve(a, b, n));
        }

        sc.close();
    }

    static int solve(int a, int b, int n) {
        if (a > b) {
            return solve(b, a, n);
        }
        if (a > n || b > n) {
            return 0;
        }

        return 1 + solve(a + b, b, n);
    }
}
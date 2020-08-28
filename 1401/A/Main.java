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
        if (k >= n) {
            return k - n;
        }

        return (k % 2 == n % 2) ? 0 : 1;
    }
}
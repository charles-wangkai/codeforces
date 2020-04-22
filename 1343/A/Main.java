import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();

            System.out.println(solve(n));
        }

        sc.close();
    }

    static int solve(int n) {
        for (int i = 4;; i *= 2) {
            if (n % (i - 1) == 0) {
                return n / (i - 1);
            }
        }
    }
}
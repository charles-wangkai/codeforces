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

    static String solve(int n) {
        boolean firstWin;
        if (n % 2 == 0) {
            int odd = n;
            while (odd % 2 == 0) {
                odd /= 2;
            }
            int even = n / odd;

            if (odd == 1) {
                firstWin = even == 2;
            } else {
                if (even == 2) {
                    firstWin = canFactorize(odd);
                } else {
                    firstWin = true;
                }
            }
        } else {
            firstWin = n != 1;
        }

        return firstWin ? "Ashishgup" : "FastestFinger";
    }

    static boolean canFactorize(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return true;
            }
        }

        return false;
    }
}
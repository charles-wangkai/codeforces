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
        int exponent2 = 0;
        while (n % 2 == 0) {
            ++exponent2;
            n /= 2;
        }

        int exponent3 = 0;
        while (n % 3 == 0) {
            ++exponent3;
            n /= 3;
        }

        return (n == 1 && exponent2 <= exponent3) ? (exponent3 * 2 - exponent2) : -1;
    }
}
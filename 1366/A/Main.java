import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(solve(a, b));
        }

        sc.close();
    }

    static int solve(int a, int b) {
        int common = Math.min(a, b);
        int extra = a + b - common * 2;

        if (extra >= common) {
            return common;
        }

        return extra + (common - extra) / 3 * 2 + (((common - extra) % 3 == 2) ? 1 : 0);
    }
}
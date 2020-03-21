import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(solve(a, b, x, y));
        }

        sc.close();
    }

    static int solve(int a, int b, int x, int y) {
        return Math.max(Math.max(x, a - 1 - x) * b, Math.max(y, b - 1 - y) * a);
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(solve(x, y, n));
        }

        sc.close();
    }

    static int solve(int x, int y, int n) {
        return y + (n - y) / x * x;
    }
}
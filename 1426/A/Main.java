import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            System.out.println(solve(n, x));
        }

        sc.close();
    }

    static int solve(int n, int x) {
        return (n <= 2) ? 1 : ((n - 2 + x - 1) / x + 1);
    }
}
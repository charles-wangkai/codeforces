import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            System.out.println(solve(n, a, b, c, d) ? "Yes" : "No");
        }

        sc.close();
    }

    static boolean solve(int n, int a, int b, int c, int d) {
        int min = n * (a - b);
        int max = n * (a + b);

        return !(min > c + d || max < c - d);
    }
}
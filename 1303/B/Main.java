import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            int n = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(solve(n, g, b));
        }

        sc.close();
    }

    static long solve(int n, int g, int b) {
        int needed = (n + 1) / 2;
        long result;
        if (needed % g == 0) {
            result = (long) needed / g * (g + b) - b;
        } else {
            result = (long) needed / g * (g + b) + needed % g;
        }

        result = Math.max(result, n);

        return result;
    }
}
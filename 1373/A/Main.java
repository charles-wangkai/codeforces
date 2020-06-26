import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            System.out.println(solve(a, b, c));
        }

        sc.close();
    }

    static String solve(int a, int b, int c) {
        return String.format("%d %d", (a < c) ? 1 : -1, (c < (long) a * b) ? b : -1);
    }
}
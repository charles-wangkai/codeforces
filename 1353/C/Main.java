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

    static long solve(int n) {
        long result = 0;
        for (int i = n; i >= 1; i -= 2) {
            result += i / 2L * 4 * (i - 1);
        }

        return result;
    }
}
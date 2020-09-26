import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            long x = sc.nextLong();

            System.out.println(solve(x));
        }

        sc.close();
    }

    static int solve(long x) {
        int result = 0;
        long n = 1;
        while (x >= n * (n + 1) / 2) {
            x -= n * (n + 1) / 2;
            ++result;

            n = n * 2 + 1;
        }

        return result;
    }
}
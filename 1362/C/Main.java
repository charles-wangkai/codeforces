import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            long n = sc.nextLong();

            System.out.println(solve(n));
        }

        sc.close();
    }

    static long solve(long n) {
        return n * 2 - Long.bitCount(n);
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            System.out.println(solve(a, b));
        }

        sc.close();
    }

    static int solve(long a, long b) {
        int powerTwoA = 0;
        while (a % 2 == 0) {
            a /= 2;
            ++powerTwoA;
        }

        int powerTwoB = 0;
        while (b % 2 == 0) {
            b /= 2;
            ++powerTwoB;
        }

        if (a != b) {
            return -1;
        }

        return (Math.abs(powerTwoA - powerTwoB) + 2) / 3;
    }
}
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
            int n = sc.nextInt();

            System.out.println(solve(a, b, x, y, n));
        }

        sc.close();
    }

    static long solve(int a, int b, int x, int y, int n) {
        return Math.min(computeProduct(a, b, x, y, n), computeProduct(b, a, y, x, n));
    }

    static long computeProduct(int current1, int current2, int lower1, int lower2, int n) {
        int oper1 = Math.min(current1 - lower1, n);
        int oper2 = Math.min(current2 - lower2, n - oper1);

        return (long) (current1 - oper1) * (current2 - oper2);
    }
}
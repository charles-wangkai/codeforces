import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(solve(a, b));
        }

        sc.close();
    }

    static int solve(int a, int b) {
        if (a == b) {
            return 0;
        } else if ((a < b && (b - a) % 2 != 0) || (a > b && (a - b) % 2 == 0)) {
            return 1;
        } else {
            return 2;
        }
    }
}
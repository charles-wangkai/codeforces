import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int x = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println(solve(x, n, m) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(int x, int n, int m) {
        while (n != 0 || m != 0) {
            if (n != 0) {
                x = Math.min(x, x / 2 + 10);
                --n;
            } else {
                x -= 10;
                --m;
            }

            if (x <= 0) {
                return true;
            }
        }

        return false;
    }
}
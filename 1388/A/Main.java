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

    static String solve(int n) {
        if (n <= 30) {
            return "NO";
        } else if (n == 36 || n == 40 || n == 44) {
            return String.format("YES\n6 10 15 %d", n - 31);
        } else {
            return String.format("YES\n6 10 14 %d", n - 30);
        }
    }
}
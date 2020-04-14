import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(solve(n, a, b));
        }

        sc.close();
    }

    static String solve(int n, int a, int b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (i < a) {
                result.append((char) (Math.min(i, b - 1) + 'a'));
            } else {
                result.append(result.charAt(i - a));
            }
        }

        return result.toString();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            System.out.println(solve(n, k));
        }

        sc.close();
    }

    static String solve(int n, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            result.append('a');
        }

        int length = 1;
        while (k > length) {
            k -= length;
            ++length;
        }
        result.setCharAt(n - length - 1, 'b');
        result.setCharAt(n - k, 'b');

        return result.toString();
    }
}
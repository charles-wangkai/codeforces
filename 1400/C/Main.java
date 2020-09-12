import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            String s = sc.next();
            int x = sc.nextInt();

            System.out.println(solve(s, x));
        }

        sc.close();
    }

    static String solve(String s, int x) {
        char[] result = new char[s.length()];
        Arrays.fill(result, '1');

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                if (i >= x) {
                    result[i - x] = '0';
                }
                if (i + x < result.length) {
                    result[i + x] = '0';
                }
            }
        }

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1' && (i < x || result[i - x] == '0')
                    && (i + x >= result.length || result[i + x] == '0')) {
                return "-1";
            }
        }

        return new String(result);
    }
}
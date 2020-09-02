import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            String[] s = new String[n];
            for (int i = 0; i < s.length; ++i) {
                s[i] = sc.next();
            }

            System.out.println(solve(s) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(String[] s) {
        int[] counts = new int[26];
        for (String si : s) {
            for (char ch : si.toCharArray()) {
                ++counts[ch - 'a'];
            }
        }

        return Arrays.stream(counts).allMatch(count -> count % s.length == 0);
    }
}
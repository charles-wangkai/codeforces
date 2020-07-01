import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            System.out.println(solve(s, k));
        }

        sc.close();
    }

    static int solve(String s, int k) {
        int result = 0;
        for (int i = 0; i <= k - 1 - i; ++i) {
            result += computeReplaceNum(s, k, i);
        }

        return result;
    }

    static int computeReplaceNum(String s, int k, int beginIndex) {
        int[] counts = new int[26];
        int total = 0;
        for (int i = beginIndex; i < s.length(); i += k) {
            ++counts[s.charAt(i) - 'a'];
            ++total;
        }

        if (k - 1 - beginIndex != beginIndex) {
            for (int i = k - 1 - beginIndex; i < s.length(); i += k) {
                ++counts[s.charAt(i) - 'a'];
                ++total;
            }
        }

        return total - Arrays.stream(counts).max().getAsInt();
    }
}
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            String s = sc.next();

            System.out.println(solve(s));
        }

        sc.close();
    }

    static int solve(String s) {
        int result = Integer.MAX_VALUE;
        int beginIndex = 0;
        int[] counts = new int[3];
        for (int endIndex = 0; endIndex < s.length(); ++endIndex) {
            ++counts[s.charAt(endIndex) - '1'];

            while (Arrays.stream(counts).allMatch(count -> count != 0) && counts[s.charAt(beginIndex) - '1'] != 1) {
                --counts[s.charAt(beginIndex) - '1'];
                ++beginIndex;
            }

            if (Arrays.stream(counts).allMatch(count -> count != 0)) {
                result = Math.min(result, endIndex - beginIndex + 1);
            }
        }

        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}
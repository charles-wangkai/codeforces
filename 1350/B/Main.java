import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] s = new int[n];
            for (int i = 0; i < s.length; ++i) {
                s[i] = sc.nextInt();
            }

            System.out.println(solve(s));
        }

        sc.close();
    }

    static int solve(int[] s) {
        int[] maxLengths = new int[s.length];
        Arrays.fill(maxLengths, 1);

        for (int i = 0; i < maxLengths.length; ++i) {
            for (int j = i * 2 + 1; j < maxLengths.length; j += i + 1) {
                if (s[j] > s[i]) {
                    maxLengths[j] = Math.max(maxLengths[j], maxLengths[i] + 1);
                }
            }
        }

        return Arrays.stream(maxLengths).max().getAsInt();
    }
}
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < h.length; ++i) {
            h[i] = sc.nextInt();
        }
        System.out.println(solve(h, a, b, k));

        sc.close();
    }

    static int solve(int[] h, int a, int b, int k) {
        int[] skipNums = Arrays.stream(h).map(hp -> computeSkipNum(a, b, hp)).sorted().toArray();

        int result = 0;
        for (int skipNum : skipNums) {
            if (skipNum <= k) {
                k -= skipNum;
                ++result;
            }
        }

        return result;
    }

    static int computeSkipNum(int a, int b, int hp) {
        int remainder = hp % (a + b);
        if (remainder >= 1 && remainder <= a) {
            return 0;
        }

        if (remainder == 0) {
            remainder = a + b;
        }

        return divideToCeil(remainder - a, a);
    }

    static int divideToCeil(int x, int y) {
        return x / y + (x % y == 0 ? 0 : 1);
    }
}
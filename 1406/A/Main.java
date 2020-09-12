import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a));
        }

        sc.close();
    }

    static int solve(int[] a) {
        Map<Integer, Integer> valueToCount = new HashMap<>();
        for (int value : a) {
            valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
        }

        int result = 0;
        for (int i = 0; i < 2; ++i) {
            int mex = 0;
            while (valueToCount.getOrDefault(mex, 0) != 0) {
                valueToCount.put(mex, valueToCount.get(mex) - 1);
                ++mex;
            }

            result += mex;
        }

        return result;
    }
}
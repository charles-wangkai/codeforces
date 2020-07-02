import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a, k));
        }

        sc.close();
    }

    static long solve(int[] a, int k) {
        Map<Integer, Integer> neededToCount = new HashMap<>();
        for (int ai : a) {
            if (ai % k != 0) {
                int needed = k - ai % k;
                neededToCount.put(needed, neededToCount.getOrDefault(needed, 0) + 1);
            }
        }

        return neededToCount.keySet().stream().mapToLong(needed -> (neededToCount.get(needed) - 1L) * k + needed + 1)
                .max().orElse(0);
    }
}
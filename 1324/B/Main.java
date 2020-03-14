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
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(a) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(int[] a) {
        Map<Integer, Integer> valueToMinIndex = new HashMap<>();
        for (int i = 0; i < a.length; ++i) {
            if (valueToMinIndex.containsKey(a[i])) {
                if (i - valueToMinIndex.get(a[i]) >= 2) {
                    return true;
                }
            } else {
                valueToMinIndex.put(a[i], i);
            }
        }

        return false;
    }
}
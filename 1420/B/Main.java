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

            System.out.println(solve(a));
        }

        sc.close();
    }

    static long solve(int[] a) {
        Map<Integer, Integer> bitNumToCount = new HashMap<>();
        for (int ai : a) {
            int bitNum = Integer.toBinaryString(ai).length();
            bitNumToCount.put(bitNum, bitNumToCount.getOrDefault(bitNum, 0) + 1);
        }

        return bitNumToCount.values().stream().mapToLong(count -> count * (count - 1L) / 2).sum();
    }
}
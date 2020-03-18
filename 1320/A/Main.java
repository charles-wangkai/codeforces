import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < b.length; ++i) {
            b[i] = sc.nextInt();
        }
        System.out.println(solve(b));

        sc.close();
    }

    static long solve(int[] b) {
        Map<Integer, Long> baseToSum = new HashMap<>();
        for (int i = 0; i < b.length; ++i) {
            int base = b[i] - i;
            baseToSum.put(base, baseToSum.getOrDefault(base, 0L) + b[i]);
        }

        return baseToSum.values().stream().mapToLong(x -> x).max().getAsLong();
    }
}
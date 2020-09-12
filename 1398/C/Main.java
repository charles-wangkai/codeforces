import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            sc.nextInt();
            String a = sc.next();

            System.out.println(solve(a));
        }

        sc.close();
    }

    static long solve(String a) {
        long result = 0;
        Map<Integer, Integer> keyToCount = new HashMap<>();
        keyToCount.put(0, 1);
        int sum = 0;
        for (int i = 0; i < a.length(); ++i) {
            sum += a.charAt(i) - '0';
            int key = sum - (i + 1);
            result += keyToCount.getOrDefault(key, 0);

            keyToCount.put(key, keyToCount.getOrDefault(key, 0) + 1);
        }

        return result;
    }
}
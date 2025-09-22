import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int k1 = sc.nextInt();
    int k2 = sc.nextInt();
    int k3 = sc.nextInt();

    System.out.println(solve(k1, k2, k3) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int k1, int k2, int k3) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : new int[] {k1, k2, k3}) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    return valueToCount.getOrDefault(1, 0) >= 1
        || valueToCount.getOrDefault(2, 0) >= 2
        || valueToCount.getOrDefault(3, 0) == 3
        || (valueToCount.getOrDefault(2, 0) == 1 && valueToCount.getOrDefault(4, 0) == 2);
  }
}
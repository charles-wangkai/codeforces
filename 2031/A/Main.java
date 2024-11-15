import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }

      System.out.println(solve(h));
    }

    sc.close();
  }

  static int solve(int[] h) {
    Map<Integer, Integer> heightToCount = new HashMap<>();
    for (int height : h) {
      heightToCount.put(height, heightToCount.getOrDefault(height, 0) + 1);
    }

    return h.length - heightToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt();
  }
}
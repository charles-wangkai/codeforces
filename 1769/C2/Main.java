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

  static int solve(int[] a) {
    Map<Integer, Integer> endToLength = new HashMap<>();
    for (int ai : a) {
      for (int d = 1; d >= 0; --d) {
        update(endToLength, ai + d);
      }
    }

    return endToLength.values().stream().mapToInt(Integer::intValue).max().getAsInt();
  }

  static void update(Map<Integer, Integer> endToLength, int end) {
    endToLength.put(
        end, Math.max(endToLength.getOrDefault(end, 0), endToLength.getOrDefault(end - 1, 0) + 1));
  }
}
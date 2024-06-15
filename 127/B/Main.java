import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    Map<Integer, Integer> lengthToCount = new HashMap<>();
    for (int ai : a) {
      lengthToCount.put(ai, lengthToCount.getOrDefault(ai, 0) + 1);
    }

    return lengthToCount.values().stream().mapToInt(count -> count / 2).sum() / 2;
  }
}
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] w = new int[n];
      for (int i = 0; i < w.length; ++i) {
        w[i] = sc.nextInt();
      }

      System.out.println(solve(w));
    }

    sc.close();
  }

  static int solve(int[] w) {
    Map<Integer, Integer> sumToRightLength = new HashMap<>();
    int rightSum = 0;
    for (int i = w.length - 1; i >= 0; --i) {
      rightSum += w[i];
      sumToRightLength.put(rightSum, w.length - i);
    }

    int result = 0;
    int leftSum = 0;
    for (int i = 0; i < w.length; ++i) {
      leftSum += w[i];

      sumToRightLength.remove(rightSum);
      rightSum -= w[i];

      if (sumToRightLength.containsKey(leftSum)) {
        result = Math.max(result, i + 1 + sumToRightLength.get(leftSum));
      }
    }

    return result;
  }
}
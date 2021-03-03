import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static String solve(int[] p) {
    int[] leftMaxs = new int[p.length];
    int leftMax = -1;
    for (int i = 0; i < leftMaxs.length; ++i) {
      leftMax = Math.max(leftMax, p[i]);
      leftMaxs[i] = leftMax;
    }

    List<Integer> result = new ArrayList<>();
    int endIndex = p.length - 1;
    for (int beginIndex = p.length - 1; beginIndex >= 0; --beginIndex) {
      if (p[beginIndex] == leftMaxs[beginIndex]) {
        for (int i = beginIndex; i <= endIndex; ++i) {
          result.add(p[i]);
        }

        endIndex = beginIndex - 1;
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}

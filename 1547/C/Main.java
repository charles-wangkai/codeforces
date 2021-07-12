import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(k, a, b));
    }

    sc.close();
  }

  static String solve(int k, int[] a, int[] b) {
    List<Integer> sequence = new ArrayList<>();
    int aIndex = 0;
    int bIndex = 0;
    while (aIndex != a.length || bIndex != b.length) {
      int action;
      if (bIndex == b.length || (aIndex != a.length && a[aIndex] <= b[bIndex])) {
        action = a[aIndex];
        ++aIndex;
      } else {
        action = b[bIndex];
        ++bIndex;
      }

      if (action == 0) {
        ++k;
      } else if (action > k) {
        return "-1";
      }

      sequence.add(action);
    }

    return sequence.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}

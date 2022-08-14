import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      valueToIndices.putIfAbsent(a[i], new ArrayList<>());
      valueToIndices.get(a[i]).add(i);
    }

    int result = 0;
    int beginIndex = 0;
    for (int i = 0; i < a.length - 1; ++i) {
      if (a[i] > a[i + 1]) {
        while (beginIndex != i + 1) {
          if (a[beginIndex] != 0) {
            ++result;
            for (int index : valueToIndices.get(a[beginIndex])) {
              a[index] = 0;
            }
          }

          ++beginIndex;
        }
      }
    }

    return result;
  }
}
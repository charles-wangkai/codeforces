import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    Map<Integer, List<Integer>> typeToDamages = new HashMap<>();
    for (int i = 0; i <= 1; ++i) {
      typeToDamages.put(i, new ArrayList<>());
    }
    for (int i = 0; i < a.length; ++i) {
      typeToDamages.get(a[i]).add(b[i]);
    }
    for (List<Integer> damages : typeToDamages.values()) {
      Collections.sort(damages, Comparator.reverseOrder());
    }

    return Math.max(
        computeMaxDamage(typeToDamages.get(0), typeToDamages.get(1)),
        computeMaxDamage(typeToDamages.get(1), typeToDamages.get(0)));
  }

  static long computeMaxDamage(List<Integer> damages1, List<Integer> damages2) {
    if (damages1.isEmpty()) {
      return Long.MIN_VALUE;
    }

    long result = damages1.get(damages1.size() - 1);
    int index1 = 0;
    int index2 = 0;
    boolean lastFirstOrSecond = true;
    while (index1 != damages1.size() - 1 || index2 != damages2.size()) {
      if (lastFirstOrSecond) {
        if (index2 != damages2.size()) {
          result += damages2.get(index2) * 2;
          ++index2;

          lastFirstOrSecond = false;
        } else {
          result += damages1.get(index1);
          ++index1;
        }
      } else {
        if (index1 != damages1.size() - 1) {
          result += damages1.get(index1) * 2;
          ++index1;

          lastFirstOrSecond = true;
        } else {
          result += damages2.get(index2);
          ++index2;
        }
      }
    }

    return result;
  }
}

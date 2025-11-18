import java.util.Comparator;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
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
      int[] c = new int[m];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int[] c) {
    NavigableMap<Integer, Integer> damageToCount = new TreeMap<>();
    for (int ai : a) {
      updateMap(damageToCount, ai, 1);
    }

    int result = 0;
    int[] sortedIndices =
        IntStream.range(0, b.length)
            .filter(i -> c[i] != 0)
            .boxed()
            .sorted(Comparator.comparing(i -> b[i]))
            .mapToInt(Integer::intValue)
            .toArray();
    for (int index : sortedIndices) {
      Integer damage = damageToCount.ceilingKey(b[index]);
      if (damage != null) {
        updateMap(damageToCount, damage, -1);
        updateMap(damageToCount, Math.max(damage, c[index]), 1);
        ++result;
      }
    }

    int[] lifes =
        IntStream.range(0, b.length).filter(i -> c[i] == 0).map(i -> b[i]).sorted().toArray();
    for (int life : lifes) {
      Integer damage = damageToCount.ceilingKey(life);
      if (damage != null) {
        updateMap(damageToCount, damage, -1);
        ++result;
      }
    }

    return result;
  }

  static void updateMap(NavigableMap<Integer, Integer> damageToCount, int damage, int delta) {
    damageToCount.put(damage, damageToCount.getOrDefault(damage, 0) + delta);
    damageToCount.remove(damage, 0);
  }
}
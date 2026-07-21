import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, int k) {
    List<Integer> counts = new ArrayList<>();
    for (int i = 0; i < a.length; ++i) {
      if (i == 0 || a[i] != a[i - 1]) {
        counts.add(1);
      } else {
        counts.set(counts.size() - 1, counts.getLast() + 1);
      }
    }
    Collections.sort(counts, Comparator.reverseOrder());

    int result = 0;
    int index = 0;
    int sum = 0;
    while (index != counts.size()) {
      while (index != counts.size() - 1 && counts.get(index).equals(counts.get(index + 1))) {
        sum += counts.get(index);
        ++index;
      }
      sum += counts.get(index);

      int base = sum - (counts.get(index) - 1) * (index + 1);
      if (k >= base && (k - base) % (index + 1) == 0) {
        ++result;
      }

      ++index;
    }

    return result;
  }
}
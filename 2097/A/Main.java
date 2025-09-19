import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

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

      System.out.println(solve(a) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    SortedMap<Integer, Integer> dayToFreq = new TreeMap<>();
    for (int ai : a) {
      dayToFreq.put(ai, dayToFreq.getOrDefault(ai, 0) + 1);
    }

    int prevDay = Integer.MIN_VALUE;
    int count = 0;
    for (int day : dayToFreq.keySet()) {
      if (day != prevDay + 1) {
        count = 0;
      }

      int freq = dayToFreq.get(day);
      if (freq >= 4) {
        return true;
      }
      if (freq > 1) {
        ++count;
        if (count == 2) {
          return true;
        }
      }

      prevDay = day;
    }

    return false;
  }
}
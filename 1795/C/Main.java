import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  static String solve(int[] a, int[] b) {
    int n = a.length;

    long[] result = new long[n];
    long bSum = 0;
    List<Long> normalizedTeas = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      result[i] -= b[i] * (n - i - 1L);
      normalizedTeas.add(a[i] + bSum);
      bSum += b[i];
    }

    Collections.sort(normalizedTeas);
    int tasterIndex = -1;
    long drinkSum = 0;
    for (int i = 0; i < normalizedTeas.size(); ++i) {
      while (tasterIndex != n - 1 && drinkSum + b[tasterIndex + 1] <= normalizedTeas.get(i)) {
        ++tasterIndex;
        drinkSum += b[tasterIndex];
        result[tasterIndex] += (long) b[tasterIndex] * (n - i);
      }

      if (tasterIndex != n - 1) {
        result[tasterIndex + 1] += normalizedTeas.get(i) - drinkSum;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

  static String solve(int[] a) {
    List<Integer> negDiffs = new ArrayList<>();
    List<Integer> posDiffs = new ArrayList<>();
    boolean hasZeroDiff = false;
    for (int i = 0; i < a.length - 1; ++i) {
      int diff = a[i + 1] - a[i];
      if (diff == 0) {
        hasZeroDiff = true;
      } else {
        ((diff < 0) ? negDiffs : posDiffs).add(diff);
      }
    }

    if (negDiffs.stream().distinct().count() > 1
        || posDiffs.stream().distinct().count() > 1
        || (hasZeroDiff && (!negDiffs.isEmpty() || !posDiffs.isEmpty()))) {
      return "-1";
    }
    if (hasZeroDiff || negDiffs.isEmpty() || posDiffs.isEmpty()) {
      return "0";
    }

    int m = -negDiffs.getFirst() + posDiffs.getFirst();

    return (Arrays.stream(a).max().getAsInt() <= m)
        ? "%d %d".formatted(m, posDiffs.getFirst())
        : "-1";
  }
}
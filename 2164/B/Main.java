import java.util.ArrayList;
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
    List<Integer> evens = new ArrayList<>();
    List<Integer> odds = new ArrayList<>();
    for (int ai : a) {
      ((ai % 2 == 0) ? evens : odds).add(ai);
    }

    if (evens.size() >= 2) {
      return "%d %d".formatted(evens.get(0), evens.get(1));
    }
    if (evens.size() == 1) {
      for (int odd : odds) {
        if (odd < evens.getFirst() && evens.getFirst() % odd % 2 == 0) {
          return "%d %d".formatted(odd, evens.getFirst());
        }
      }
    }

    for (int i = 0; i < odds.size() - 1; ++i) {
      if (odds.get(i + 1) % odds.get(i) % 2 == 0) {
        return "%d %d".formatted(odds.get(i), odds.get(i + 1));
      }
    }

    for (int i = 0; i < odds.size(); ++i) {
      for (int j = i + 1; j < odds.size(); ++j) {
        if (odds.get(j) % odds.get(i) % 2 == 0) {
          return "%d %d".formatted(odds.get(i), odds.get(j));
        }
      }
    }

    return "-1";
  }
}
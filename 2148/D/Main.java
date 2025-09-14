import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

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

  static long solve(int[] a) {
    List<Integer> evens = new ArrayList<>();
    List<Integer> odds = new ArrayList<>();
    for (int ai : a) {
      ((ai % 2 == 0) ? evens : odds).add(ai);
    }

    Collections.sort(odds, Comparator.reverseOrder());

    return (odds.isEmpty())
        ? 0
        : (IntStream.range(0, (odds.size() + 1) / 2).map(odds::get).asLongStream().sum()
            + evens.stream().mapToInt(Integer::intValue).asLongStream().sum());
  }
}
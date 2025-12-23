import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, x));

    sc.close();
  }

  static int solve(int[] a, int x) {
    List<Integer> values = new ArrayList<>();
    for (int ai : a) {
      values.add(ai);
    }

    while (computeMedian(values) != x) {
      values.add(x);
    }

    return values.size() - a.length;
  }

  static int computeMedian(List<Integer> values) {
    Collections.sort(values);

    return values.get((values.size() - 1) / 2);
  }
}
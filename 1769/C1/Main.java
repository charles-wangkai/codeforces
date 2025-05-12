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

  static int solve(int[] a) {
    return IntStream.rangeClosed(a[0], a[a.length - 1])
        .map(begin -> computeDayNum(a, begin))
        .max()
        .getAsInt();
  }

  static int computeDayNum(int[] a, int begin) {
    int end = begin;
    for (int ai : a) {
      if (ai == end || ai + 1 == end) {
        ++end;
      }
    }

    return end - begin;
  }
}
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    String s = sc.next();

    System.out.println(solve(a, s) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int[] a, String s) {
    int beginIndex = 0;
    while (beginIndex != a.length) {
      int endIndex = beginIndex;
      while (endIndex != a.length - 1 && s.charAt(endIndex) == '1') {
        ++endIndex;
      }

      int beginIndex_ = beginIndex;
      int endIndex_ = endIndex;
      if (!IntStream.rangeClosed(beginIndex, endIndex)
          .allMatch(i -> a[i] >= beginIndex_ + 1 && a[i] <= endIndex_ + 1)) {
        return false;
      }

      beginIndex = endIndex + 1;
    }

    return true;
  }
}
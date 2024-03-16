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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int prev = -1;
    for (int ai : a) {
      int[] digits = String.valueOf(ai).chars().map(c -> c - '0').toArray();
      if (IntStream.range(0, digits.length - 1).allMatch(i -> digits[i] <= digits[i + 1])
          && digits[0] >= prev) {
        prev = digits[digits.length - 1];
      } else if (ai >= prev) {
        prev = ai;
      } else {
        return false;
      }
    }

    return true;
  }
}
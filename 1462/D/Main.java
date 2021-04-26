import java.util.Arrays;
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

  static int solve(int[] a) {
    int total = Arrays.stream(a).sum();
    int length = a.length;
    for (int result = 0; ; ++result, --length) {
      if (total % length == 0 && check(a, total / length)) {
        return result;
      }
    }
  }

  static boolean check(int[] a, int partSum) {
    int rest = partSum;
    for (int ai : a) {
      rest -= ai;
      if (rest < 0) {
        return false;
      }
      if (rest == 0) {
        rest = partSum;
      }
    }

    return true;
  }
}

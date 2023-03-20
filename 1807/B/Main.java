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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int evenSum = 0;
    int oddSum = 0;
    for (int ai : a) {
      if (ai % 2 == 0) {
        evenSum += ai;
      } else {
        oddSum += ai;
      }
    }

    return evenSum > oddSum;
  }
}

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
    int result = 0;
    int last1 = Integer.MAX_VALUE;
    int last2 = Integer.MAX_VALUE;
    for (int ai : a) {
      if (ai <= last2) {
        last2 = ai;
      } else if (ai <= last1) {
        last1 = ai;
      } else {
        ++result;
        last2 = last1;
        last1 = ai;
      }
    }

    return result;
  }
}
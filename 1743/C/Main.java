import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      String lids = sc.next();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, lids));
    }

    sc.close();
  }

  static int solve(int[] a, String lids) {
    int result = 0;
    int sum = 0;
    int min = 0;
    for (int i = 0; i <= a.length; ++i) {
      if (i != a.length && lids.charAt(i) == '1') {
        sum += a[i];
        min = Math.min(min, a[i]);
      } else {
        result += sum - min;
        if (i != a.length) {
          sum = a[i];
          min = a[i];
        }
      }
    }

    return result;
  }
}

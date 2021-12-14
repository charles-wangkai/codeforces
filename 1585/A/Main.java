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
    int result = 1;
    for (int i = 0; i < a.length; ++i) {
      if (a[i] == 1) {
        result += (i != 0 && a[i - 1] == 1) ? 5 : 1;
      } else if (i != 0 && a[i - 1] == 0) {
        return -1;
      }
    }

    return result;
  }
}

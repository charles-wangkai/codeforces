import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] x) {
    ++x[0];
    for (int i = 1; i < x.length; ++i) {
      int diff = x[i] - x[i - 1];
      if (diff == 0) {
        ++x[i];
      } else if (diff == 2) {
        --x[i];
      } else if (diff != 1) {
        return false;
      }
    }

    return true;
  }
}
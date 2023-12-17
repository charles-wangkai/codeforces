import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      System.out.println(solve(u, v));
    }

    sc.close();
  }

  static int solve(int[] u, int[] v) {
    int n = u.length + 1;

    int[] degrees = new int[n];
    for (int i = 0; i < u.length; ++i) {
      ++degrees[u[i] - 1];
      ++degrees[v[i] - 1];
    }

    int result = 1;
    int oddCount = 0;
    for (int i = 0; i < degrees.length; ++i) {
      int count = Math.max(0, degrees[i] - 2);
      result += count / 2;
      if (count % 2 == 1) {
        ++oddCount;
      }
    }
    result += (oddCount + 1) / 2;

    return result;
  }
}
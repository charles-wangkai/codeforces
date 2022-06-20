import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m));
    }

    sc.close();
  }

  static long solve(int n, int m) {
    long result = 0;
    for (int c = 0; c < m; ++c) {
      result += c + 1;
    }
    for (int r = 1; r < n; ++r) {
      result += r * m + m;
    }

    return result;
  }
}
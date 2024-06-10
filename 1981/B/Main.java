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

  static int solve(int n, int m) {
    int result = 0;
    int lower = Math.max(0, n - m);
    int upper = n + m;
    int b = 0;
    while (upper != 0) {
      if ((lower & 1) == 1 || (upper & 1) == 1 || lower != upper) {
        result += 1 << b;
      }

      lower >>= 1;
      upper >>= 1;
      ++b;
    }

    return result;
  }
}
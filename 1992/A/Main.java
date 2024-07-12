import java.util.Scanner;

public class Main {
  static final int LIMIT = 5;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static int solve(int a, int b, int c) {
    int result = -1;
    for (int da = 0; da <= LIMIT; ++da) {
      for (int db = 0; da + db <= LIMIT; ++db) {
        int dc = LIMIT - da - db;
        result = Math.max(result, (a + da) * (b + db) * (c + dc));
      }
    }

    return result;
  }
}
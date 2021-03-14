import java.util.Scanner;

public class Main {
  static final int INF = 10000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      String map = sc.next();

      System.out.println(solve(a, b, map));
    }

    sc.close();
  }

  static int solve(int a, int b, String map) {
    int result = 0;
    int prevIndex = -INF;
    for (int i = 0; i < map.length(); ++i) {
      if (map.charAt(i) == '1') {
        result += Math.min(a, b * (i - prevIndex - 1));
        prevIndex = i;
      }
    }

    return result;
  }
}

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int a = sc.nextInt();
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(n, a, s));
    }

    sc.close();
  }

  static String solve(int n, int a, String s) {
    int onlineCount = a;
    int maxOnlineCount = a;
    for (char c : s.toCharArray()) {
      if (c == '+') {
        ++onlineCount;
      } else {
        --onlineCount;
      }

      maxOnlineCount = Math.max(maxOnlineCount, onlineCount);
    }

    if (maxOnlineCount == n) {
      return "YES";
    }

    return (a + s.chars().filter(c -> c == '+').count() >= n) ? "MAYBE" : "NO";
  }
}

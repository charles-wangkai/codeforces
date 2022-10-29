import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(String s) {
    int qCount = 0;
    for (char c : s.toCharArray()) {
      if (c == 'Q') {
        ++qCount;
      } else if (qCount != 0) {
        --qCount;
      }
    }

    return qCount == 0;
  }
}

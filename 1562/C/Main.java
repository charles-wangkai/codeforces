import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int index = s.indexOf('0');

    int l1;
    int r1;
    int l2;
    int r2;
    if (index == -1) {
      l1 = 1;
      r1 = s.length() - 1;
      l2 = 2;
      r2 = s.length();
    } else if (index >= s.length() - 1 - index) {
      l1 = 1;
      r1 = index + 1;
      l2 = 1;
      r2 = index;
    } else {
      l1 = index + 1;
      r1 = s.length();
      l2 = index + 2;
      r2 = s.length();
    }

    return String.format("%d %d %d %d", l1, r1, l2, r2);
  }
}
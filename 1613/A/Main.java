import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x1 = sc.nextInt();
      int p1 = sc.nextInt();
      int x2 = sc.nextInt();
      int p2 = sc.nextInt();

      System.out.println(solve(x1, p1, x2, p2));
    }

    sc.close();
  }

  static String solve(int x1, int p1, int x2, int p2) {
    int length1 = String.valueOf(x1).length() + p1;
    int length2 = String.valueOf(x2).length() + p2;
    if (length1 < length2) {
      return "<";
    } else if (length1 > length2) {
      return ">";
    }

    int minP = Math.min(p1, p2);
    long prefix1 = Long.parseLong(x1 + "0".repeat(p1 - minP));
    long prefix2 = Long.parseLong(x2 + "0".repeat(p2 - minP));
    if (prefix1 < prefix2) {
      return "<";
    } else if (prefix1 > prefix2) {
      return ">";
    }

    return "=";
  }
}

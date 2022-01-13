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

  static int solve(String s) {
    if (s.contains("aa")) {
      return 2;
    }
    if (s.contains("aba") || s.contains("aca")) {
      return 3;
    }
    if (s.contains("abca") || s.contains("acba")) {
      return 4;
    }
    if (s.contains("abbacca") || s.contains("accabba")) {
      return 7;
    }

    return -1;
  }
}

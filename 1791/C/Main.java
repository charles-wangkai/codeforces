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
    int beginIndex = 0;
    int endIndex = s.length() - 1;
    while (beginIndex <= endIndex && s.charAt(beginIndex) != s.charAt(endIndex)) {
      ++beginIndex;
      --endIndex;
    }

    return endIndex - beginIndex + 1;
  }
}

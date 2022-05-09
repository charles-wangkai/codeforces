import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    int beginIndex = s.lastIndexOf('1');
    if (beginIndex == -1) {
      beginIndex = 0;
    }

    int endIndex = s.indexOf('0');
    if (endIndex == -1) {
      endIndex = s.length() - 1;
    }

    return endIndex - beginIndex + 1;
  }
}
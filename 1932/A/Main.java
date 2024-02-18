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
    int endIndex = s.indexOf("**");
    if (endIndex == -1) {
      endIndex = s.length();
    }

    return (int) s.substring(0, endIndex).chars().filter(c -> c == '@').count();
  }
}
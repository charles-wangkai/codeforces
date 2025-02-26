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

  static long solve(String s) {
    int dashCount = (int) s.chars().filter(c -> c == '-').count();
    int underscoreCount = s.length() - dashCount;

    return (dashCount / 2L) * (dashCount - dashCount / 2) * underscoreCount;
  }
}
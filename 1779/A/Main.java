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
    if (s.contains("RL")) {
      return 0;
    }

    int index = s.indexOf("LR");

    return (index == -1) ? -1 : (index + 1);
  }
}

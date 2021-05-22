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
    int zeroCount = (int) s.chars().filter(ch -> ch == '0').count();

    return (zeroCount % 2 != 0 && zeroCount != 1) ? "ALICE" : "BOB";
  }
}

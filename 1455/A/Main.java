import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String n = sc.next();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(String n) {
    return n.length();
  }
}

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int s = sc.nextInt();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(int s) {
    int result = 0;
    for (int i = 1; s > 0; i += 2) {
      s -= i;
      ++result;
    }

    return result;
  }
}

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(x, k));
    }

    sc.close();
  }

  static String solve(int x, int k) {
    return (x % k == 0) ? String.format("2\n%d 1", x - 1) : String.format("1\n%d", x);
  }
}

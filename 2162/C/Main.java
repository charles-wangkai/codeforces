import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int a, int b) {
    int x1 = (Integer.highestOneBit(a) * 2 - 1) ^ a;
    a ^= x1;

    if (b > a) {
      return "-1";
    }

    int x2 = b ^ a;

    return "2\n%d %d".formatted(x1, x2);
  }
}
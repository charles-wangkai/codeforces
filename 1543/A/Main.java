import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long a = sc.nextLong();
      long b = sc.nextLong();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(long a, long b) {
    long diff = Math.abs(a - b);
    if (diff == 0) {
      return "0 0";
    }

    long moveNum = Math.min(a % diff, diff - a % diff);

    return String.format("%d %d", diff, moveNum);
  }
}

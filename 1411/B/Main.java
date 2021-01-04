import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static long solve(long n) {
    while (!isFair(n)) {
      ++n;
    }

    return n;
  }

  static boolean isFair(long n) {
    return String.valueOf(n).chars().allMatch(ch -> ch == '0' || n % (ch - '0') == 0);
  }
}

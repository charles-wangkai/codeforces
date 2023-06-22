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
    long result = 0;
    while (n != 0) {
      result += n;
      n /= 2;
    }

    return result;
  }
}

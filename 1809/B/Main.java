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

  static int solve(long n) {
    int size = (int) Math.round(Math.sqrt(n));
    if ((long) size * size < n) {
      ++size;
    }

    return size - 1;
  }
}

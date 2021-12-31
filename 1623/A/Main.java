import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int rb = sc.nextInt();
      int cb = sc.nextInt();
      int rd = sc.nextInt();
      int cd = sc.nextInt();

      System.out.println(solve(n, m, rb, cb, rd, cd));
    }

    sc.close();
  }

  static int solve(int n, int m, int rb, int cb, int rd, int cd) {
    return Math.min(computeTime(n, rb, rd), computeTime(m, cb, cd));
  }

  static int computeTime(int size, int from, int to) {
    return (to >= from) ? (to - from) : (size - from + size - to);
  }
}

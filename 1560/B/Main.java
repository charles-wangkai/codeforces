import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static int solve(int a, int b, int c) {
    int diff = Math.abs(a - b);
    int max = diff * 2;
    if (a > max || b > max || c > max) {
      return -1;
    }

    return (c <= diff) ? (c + diff) : (c - diff);
  }
}

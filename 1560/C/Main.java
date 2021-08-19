import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();

      System.out.println(solve(k));
    }

    sc.close();
  }

  static String solve(int k) {
    int radius = 1;
    while (k > 2 * radius - 1) {
      k -= 2 * radius - 1;
      ++radius;
    }

    int r;
    int c;
    if (k <= radius) {
      r = k;
      c = radius;
    } else {
      r = radius;
      c = radius - (k - radius);
    }

    return String.format("%d %d", r, c);
  }
}

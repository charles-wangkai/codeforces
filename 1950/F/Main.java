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
    if (a + 1 != c) {
      return -1;
    }

    int result = 0;
    int width = 1;
    while (a != 0) {
      if (a < width) {
        b -= Math.min(b, width - a);
        width += a;
        a = 0;
      } else {
        a -= width;
        width *= 2;
      }

      ++result;
    }
    result += (b + width - 1) / width;

    return result;
  }
}
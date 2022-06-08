import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    int base = (n - 6) / 3;
    int h2 = base + 2;
    int h1 = base + 3;
    int h3 = base + 1;
    int rest = (n - 6) % 3;
    if (rest == 1) {
      ++h1;
    } else if (rest == 2) {
      ++h1;
      ++h2;
    }

    return String.format("%d %d %d", h2, h1, h3);
  }
}
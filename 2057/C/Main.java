import java.util.Scanner;

public class Main {
  static final int BIT_NUM = 30;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static String solve(int l, int r) {
    int prefix = 0;
    int bit = BIT_NUM;
    while (((l >> bit) & 1) == ((r >> bit) & 1)) {
      prefix += l & (1 << bit);
      --bit;
    }

    int a = prefix + (1 << bit);
    int b = a - 1;
    int c = (a + 1 >= l && a + 1 <= r) ? (a + 1) : (b - 1);

    return "%d %d %d".formatted(a, b, c);
  }
}
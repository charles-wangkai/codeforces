import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      int L = sc.nextInt();
      int R = sc.nextInt();

      System.out.println(solve(l, r, L, R));
    }

    sc.close();
  }

  static int solve(int l, int r, int L, int R) {
    int min = Math.max(l, L);
    int max = Math.min(r, R);
    if (min > max) {
      return 1;
    }

    return max
        - min
        + (((min - 1 >= l && min - 1 <= r) || (min - 1 >= L && min - 1 <= R)) ? 1 : 0)
        + (((max + 1 >= l && max + 1 <= r) || (max + 1 >= L && max + 1 <= R)) ? 1 : 0);
  }
}
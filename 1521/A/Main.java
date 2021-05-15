import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int A = sc.nextInt();
      int B = sc.nextInt();

      System.out.println(solve(A, B));
    }

    sc.close();
  }

  static String solve(int A, int B) {
    if (B == 1) {
      return "NO";
    }

    int x;
    long y;
    long z;
    if (B == 2) {
      x = A;
      y = 3L * A * (B - 1);
      z = 2L * A * B;
    } else {
      x = A;
      y = A * (B - 1L);
      z = (long) A * B;
    }

    return String.format("YES\n%d %d %d", x, y, z);
  }
}

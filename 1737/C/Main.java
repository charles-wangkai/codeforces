import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int r1 = sc.nextInt();
      int c1 = sc.nextInt();
      int r2 = sc.nextInt();
      int c2 = sc.nextInt();
      int r3 = sc.nextInt();
      int c3 = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(n, r1, c1, r2, c2, r3, c3, x, y) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int r1, int c1, int r2, int c2, int r3, int c3, int x, int y) {
    int centerR = findCenter(r1, r2, r3);
    int centerC = findCenter(c1, c2, c3);

    return x == centerR
        || y == centerC
        || (((x - centerR) % 2 == 0 || (y - centerC) % 2 == 0)
            && (!(centerR == 1 || centerR == n) || !(centerC == 1 || centerC == n)));
  }

  static int findCenter(int value1, int value2, int value3) {
    return IntStream.of(value1, value2, value3).sorted().skip(1).findFirst().getAsInt();
  }
}
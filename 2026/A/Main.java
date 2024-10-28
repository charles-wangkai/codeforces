import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int X = sc.nextInt();
      int Y = sc.nextInt();
      int K = sc.nextInt();

      System.out.println(solve(X, Y, K));
    }

    sc.close();
  }

  static String solve(int X, int Y, int K) {
    int size = Math.min(X, Y);

    return "0 0 %d %d\n0 %d %d 0".formatted(size, size, size, size);
  }
}
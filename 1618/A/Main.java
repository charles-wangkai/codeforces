import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int[] b = new int[7];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(int[] b) {
    return String.format("%d %d %d", b[0], b[1], b[6] - b[0] - b[1]);
  }
}

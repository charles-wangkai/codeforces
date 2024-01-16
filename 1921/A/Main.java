import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int[] x = new int[4];
      int[] y = new int[4];
      for (int i = 0; i < 4; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static int solve(int[] x, int[] y) {
    return (Arrays.stream(x).max().getAsInt() - Arrays.stream(x).min().getAsInt())
        * (Arrays.stream(y).max().getAsInt() - Arrays.stream(y).min().getAsInt());
  }
}
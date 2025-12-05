import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static int solve(int[] b) {
    return (int)
        Math.min(
            (int) Arrays.stream(b).filter(x -> x != 0).count(),
            Arrays.stream(b).asLongStream().sum() - b.length + 1);
  }
}
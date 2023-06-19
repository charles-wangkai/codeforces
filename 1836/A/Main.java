import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 100;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] l = new int[n];
      for (int i = 0; i < l.length; ++i) {
        l[i] = sc.nextInt();
      }

      System.out.println(solve(l) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] l) {
    int[] counts = new int[LIMIT];
    for (int li : l) {
      ++counts[li];
    }

    return IntStream.range(1, counts.length).allMatch(i -> counts[i] <= counts[i - 1]);
  }
}

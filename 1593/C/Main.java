import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] x = new int[k];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(n, x));
    }

    sc.close();
  }

  static int solve(int n, int[] x) {
    int[] sorted = Arrays.stream(x).boxed().sorted().mapToInt(xi -> xi).toArray();
    int catPos = 0;
    int result = 0;
    for (int i = sorted.length - 1; i >= 0 && sorted[i] > catPos; --i) {
      catPos += n - sorted[i];
      ++result;
    }

    return result;
  }
}

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int H = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, H));
    }

    sc.close();
  }

  static int solve(int[] a, int H) {
    int[] sorted =
        Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();

    int result = H / (sorted[0] + sorted[1]) * 2;
    H %= sorted[0] + sorted[1];
    if (H > sorted[0]) {
      result += 2;
    } else if (H != 0) {
      ++result;
    }

    return result;
  }
}

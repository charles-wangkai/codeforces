import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(b, p));
    }

    sc.close();
  }

  static String solve(int[] b, int[] p) {
    int n = b.length;

    int[] result = new int[n];
    int[] distances = new int[n];
    Arrays.fill(distances, -1);
    for (int i = 0; i < p.length; ++i) {
      if (b[p[i] - 1] == p[i]) {
        distances[p[i] - 1] = 0;
      } else if (distances[b[p[i] - 1] - 1] == -1) {
        return "-1";
      } else {
        distances[p[i] - 1] = distances[p[i - 1] - 1] + 1;
        result[p[i] - 1] = distances[p[i] - 1] - distances[b[p[i] - 1] - 1];
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}

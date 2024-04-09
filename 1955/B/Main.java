import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int c = sc.nextInt();
      int d = sc.nextInt();
      int[] b = new int[n * n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(n, b, c, d) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int[] b, int c, int d) {
    int min = Arrays.stream(b).min().getAsInt();

    List<Integer> values = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        values.add(min + i * c + j * d);
      }
    }

    return Arrays.equals(
        values.stream().sorted().mapToInt(Integer::intValue).toArray(),
        Arrays.stream(b).sorted().toArray());
  }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    if (IntStream.range(0, a.length - 1).allMatch(i -> a[i] <= a[i + 1])) {
      return "0";
    }
    if (a[a.length - 1] < 0 || a[a.length - 2] > a[a.length - 1]) {
      return "-1";
    }

    List<String> operations = new ArrayList<>();
    for (int i = a.length - 2; i >= 1; --i) {
      operations.add(String.format("%d %d %d", i, i + 1, a.length));
    }

    return String.format("%d\n%s", operations.size(), String.join("\n", operations));
  }
}
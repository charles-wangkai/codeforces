import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, int k) {
    List<Integer> result = new ArrayList<>();
    for (int i = n - k; i <= n; ++i) {
      result.add(i);
    }
    for (int i = n - k - 1; i >= 1; --i) {
      result.add(i);
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}
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

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    List<Integer> result = new ArrayList<>();
    int lower = (n + 1) / 2;
    int upper = n;
    for (int i = 0; i < n / 2; ++i) {
      result.add(lower - i);
      result.add(upper - i);
    }
    if (n % 2 != 0) {
      result.add(1);
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}

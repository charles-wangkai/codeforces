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
      int d = sc.nextInt();

      System.out.println(solve(n, d));
    }

    sc.close();
  }

  static String solve(int n, int d) {
    List<Integer> result = new ArrayList<>();
    result.add(1);

    if (d % 3 == 0 || n >= 3) {
      result.add(3);
    }

    if (d % 5 == 0) {
      result.add(5);
    }

    if (d == 7 || n >= 3) {
      result.add(7);
    }

    if (d == 9 || n >= 6 || (d % 3 == 0 && n >= 3)) {
      result.add(9);
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();
      long x = sc.nextLong();

      System.out.println(solve(k, x));
    }

    sc.close();
  }

  static String solve(int k, long x) {
    long y = (1L << (k + 1)) - x;
    while ((x & 1) == 0) {
      x >>= 1;
      y >>= 1;
    }

    x >>= 1;
    y >>= 1;

    List<Integer> operations = new ArrayList<>();
    while (x != 0 || y != 0) {
      operations.add(((x & 1) == 0) ? 1 : 2);

      x >>= 1;
      y >>= 1;
    }

    return "%d\n%s"
        .formatted(
            operations.size(),
            operations.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}
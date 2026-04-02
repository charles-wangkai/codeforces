import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static String solve(int x, int y) {
    return "%d\n%s"
        .formatted(
            computePartitionNum(Math.abs(x - y)),
            IntStream.range(0, x + y)
                .map(i -> (i < x) ? 1 : -1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }

  static int computePartitionNum(int length) {
    return (length == 0)
        ? 1
        : (int) IntStream.rangeClosed(1, length).filter(x -> length % x == 0).count();
  }
}

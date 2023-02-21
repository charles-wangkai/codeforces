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
    return String.format(
        "%d\n%s",
        (x - y) * 2,
        IntStream.range(0, (x - y) * 2)
            .map(i -> y + Math.abs(i - (x - y)))
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" ")));
  }
}

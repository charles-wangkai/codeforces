import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int r = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(r, b));
    }

    sc.close();
  }

  static String solve(int r, int b) {
    return IntStream.range(0, b + 1)
        .map(i -> r / (b + 1) + ((i < r % (b + 1)) ? 1 : 0))
        .mapToObj("R"::repeat)
        .collect(Collectors.joining("B"));
  }
}
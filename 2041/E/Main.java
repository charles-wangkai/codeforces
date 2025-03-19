import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int LIMIT = 1_000_000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(a, b));

    sc.close();
  }

  static String solve(int a, int b) {
    int[] result = {-LIMIT, b, LIMIT};

    int delta = 3 * a - b;
    result[(delta > 0) ? 0 : 2] += delta;

    return "%d\n%s"
        .formatted(
            result.length,
            Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
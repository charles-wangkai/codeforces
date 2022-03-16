import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    List<Integer> elements =
        IntStream.range(1, n).filter(i -> gcd(i, n) == 1).boxed().collect(Collectors.toList());

    int product = elements.stream().mapToInt(x -> x).reduce(1, (x, y) -> (int) ((long) x * y % n));
    if (product != 1) {
      elements.remove(Integer.valueOf(product));
    }

    return String.format(
        "%d\n%s",
        elements.size(), elements.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
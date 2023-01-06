import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final String COLORS = "ROYGBIV";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    return IntStream.range(0, n)
        .map(i -> (i < 7) ? i : ((i - 7) % 4 + 3))
        .mapToObj(COLORS::charAt)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}

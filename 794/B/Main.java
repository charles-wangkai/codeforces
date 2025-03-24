import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int h = sc.nextInt();

    System.out.println(solve(n, h));

    sc.close();
  }

  static String solve(int n, int h) {
    return IntStream.range(0, n - 1)
        .mapToDouble(i -> Math.sqrt((i + 1.0) / n) * h)
        .mapToObj("%.9f"::formatted)
        .collect(Collectors.joining(" "));
  }
}
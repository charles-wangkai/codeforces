import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    int period = 1;
    while (period != n && n % period == 0) {
      ++period;
    }

    int period_ = period;
    return IntStream.range(0, n)
        .mapToObj(i -> (char) (i % period_ + 'a'))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}

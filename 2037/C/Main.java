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
    if (n <= 4) {
      return "-1";
    }

    return IntStream.concat(
            IntStream.concat(
                IntStream.rangeClosed(1, n).filter(x -> x % 2 == 0 && x != 4), IntStream.of(4)),
            IntStream.concat(
                IntStream.of(5), IntStream.rangeClosed(1, n).filter(x -> x % 2 == 1 && x != 5)))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}
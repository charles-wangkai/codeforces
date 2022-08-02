import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int s = sc.nextInt();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(int s) {
    return IntStream.range(1, 1 << 9)
        .mapToObj(
            i ->
                IntStream.rangeClosed(1, 9)
                    .filter(x -> (i & (1 << (x - 1))) != 0)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining()))
        .mapToInt(Integer::parseInt)
        .filter(x -> computeDigitSum(x) == s)
        .min()
        .getAsInt();
  }

  static int computeDigitSum(int x) {
    return String.valueOf(x).chars().map(c -> c - '0').sum();
  }
}
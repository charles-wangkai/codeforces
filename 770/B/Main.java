import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long x = sc.nextLong();

    System.out.println(solve(x));

    sc.close();
  }

  static long solve(long x) {
    String s = String.valueOf(x);

    return LongStream.concat(
            LongStream.of(x),
            IntStream.range(1, s.length())
                .mapToLong(
                    i ->
                        Long.parseLong(
                            "%d%s"
                                .formatted(
                                    Long.parseLong(s.substring(0, s.length() - i)) - 1,
                                    "9".repeat(i)))))
        .boxed()
        .max(Comparator.comparing(Main::computeDigitSum).thenComparing(a -> a))
        .get();
  }

  static int computeDigitSum(long x) {
    return String.valueOf(x).chars().map(c -> c - '0').sum();
  }
}
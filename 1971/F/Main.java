import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int r = sc.nextInt();

      System.out.println(solve(r));
    }

    sc.close();
  }

  static long solve(int r) {
    return IntStream.rangeClosed(-r, r)
        .map(
            x -> {
              int lower = (int) Math.floor(Math.sqrt((long) r * r - (long) x * x));
              while ((long) lower * lower < (long) r * r - (long) x * x) {
                ++lower;
              }

              int upper = (int) Math.ceil(Math.sqrt((r + 1L) * (r + 1) - (long) x * x));
              while ((long) upper * upper >= (r + 1L) * (r + 1) - (long) x * x) {
                --upper;
              }

              return (upper - lower + 1) * 2 - ((lower == 0) ? 1 : 0);
            })
        .asLongStream()
        .sum();
  }
}
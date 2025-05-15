import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long l = sc.nextLong();
      long r = sc.nextLong();

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static long solve(long l, long r) {
    return computeLuxuryNum(r) - computeLuxuryNum(l - 1);
  }

  static long computeLuxuryNum(long limit) {
    return IntStream.range(0, 3)
        .mapToLong(factorDiff -> computeProductNum(limit, factorDiff))
        .sum();
  }

  static long computeProductNum(long limit, int factorDiff) {
    int result = 0;
    int lower = 1;
    int upper = (int) Math.ceil(Math.sqrt(limit));
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if ((long) middle * (middle + factorDiff) <= limit) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }
}
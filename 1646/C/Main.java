import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(long n) {
    List<Long> factorials = new ArrayList<>();
    factorials.add(1L);
    while (true) {
      long next = factorials.get(factorials.size() - 1) * factorials.size();
      if (next > n) {
        break;
      }

      factorials.add(next);
    }

    return IntStream.range(0, 1 << factorials.size())
        .map(
            mask -> {
              long rest =
                  n
                      - IntStream.range(0, factorials.size())
                          .filter(i -> (mask & (1 << i)) != 0)
                          .mapToLong(factorials::get)
                          .sum();

              return (rest < 0)
                  ? Integer.MAX_VALUE
                  : (Integer.bitCount(mask) + Long.bitCount(rest));
            })
        .min()
        .getAsInt();
  }
}

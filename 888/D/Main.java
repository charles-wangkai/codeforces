import static java.util.Map.entry;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static Map<Integer, Integer> DIFF_NUM_TO_WAY_NUM =
      Map.ofEntries(entry(1, 0), entry(2, 1), entry(3, 2), entry(4, 9));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static long solve(int n, int k) {
    return 1
        + IntStream.rangeClosed(1, k)
            .mapToLong(diffNum -> C(n, diffNum) * DIFF_NUM_TO_WAY_NUM.get(diffNum))
            .sum();
  }

  static long C(int n, int r) {
    long result = 1;
    for (int i = 0; i < r; ++i) {
      result = result * (n - i) / (i + 1);
    }

    return result;
  }
}
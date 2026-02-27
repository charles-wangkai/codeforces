import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long x = sc.nextLong();

      System.out.println(solve(x));
    }

    sc.close();
  }

  static int solve(long x) {
    int[] digits = String.valueOf(x).chars().map(c -> c - '0').toArray();
    int digitSum = Arrays.stream(digits).sum();

    int[] deltas =
        IntStream.range(0, digits.length)
            .map(i -> digits[i] - ((i == 0) ? 1 : 0))
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    int result = 0;
    int deltaIndex = 0;
    while (digitSum >= 10) {
      digitSum -= deltas[deltaIndex];
      ++deltaIndex;
      ++result;
    }

    return result;
  }
}
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int[] sortedNonPositives =
        Arrays.stream(a).filter(x -> x <= 0).boxed().sorted().mapToInt(x -> x).toArray();
    OptionalInt minPositive = Arrays.stream(a).filter(x -> x > 0).min();

    return sortedNonPositives.length
        + ((minPositive.isPresent()
                && IntStream.range(0, sortedNonPositives.length - 1)
                    .allMatch(
                        i ->
                            sortedNonPositives[i + 1] - sortedNonPositives[i]
                                >= minPositive.getAsInt()))
            ? 1
            : 0);
  }
}

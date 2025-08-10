import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long m = sc.nextLong();

      System.out.println(solve(n, m));
    }

    sc.close();
  }

  static String solve(int n, long m) {
    long diff = n * (n + 1L) / 2 - m;
    if (diff < 0 || diff > n * (n - 1L) / 2) {
      return "-1";
    }

    boolean[] used = new boolean[n];
    for (int i = used.length - 1; i >= 1; --i) {
      if (diff >= i) {
        used[i] = true;
        diff -= i;
      }
    }

    int[] unusedIndices = IntStream.range(0, used.length).filter(i -> !used[i]).toArray();

    return "%d\n%s"
        .formatted(
            unusedIndices[unusedIndices.length - 1] + 1,
            Stream.concat(
                    IntStream.range(0, unusedIndices.length - 1)
                        .mapToObj(
                            i -> "%d %d".formatted(unusedIndices[i] + 1, unusedIndices[i + 1] + 1)),
                    IntStream.range(0, used.length)
                        .filter(i -> used[i])
                        .mapToObj(i -> "1 %d".formatted(i + 1)))
                .collect(Collectors.joining("\n")));
  }
}
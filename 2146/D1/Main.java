import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static String solve(int l, int r) {
    int[] a = new int[r + 1];
    int endIndex = a.length - 1;
    while (endIndex != -1) {
      int beginIndex =
          (endIndex == 0)
              ? 0
              : Integer.parseInt(
                  Integer.toBinaryString(endIndex)
                      .chars()
                      .mapToObj(c -> (char) ('0' + '1' - c))
                      .map(String::valueOf)
                      .collect(Collectors.joining()),
                  2);

      for (int i = beginIndex; i <= endIndex; ++i) {
        a[i] = beginIndex + endIndex - i;
      }

      endIndex = beginIndex - 1;
    }

    return "%d\n%s"
        .formatted(
            IntStream.range(0, a.length).map(i -> i | a[i]).asLongStream().sum(),
            Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
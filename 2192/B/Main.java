import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int[] oneIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '1').toArray();
    if (oneIndices.length % 2 == 0) {
      return "%d\n%s"
          .formatted(
              oneIndices.length,
              Arrays.stream(oneIndices)
                  .map(oneIndex -> oneIndex + 1)
                  .mapToObj(String::valueOf)
                  .collect(Collectors.joining(" ")));
    }

    int[] zeroIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '0').toArray();

    return (zeroIndices.length % 2 == 1)
        ? "%d\n%s"
            .formatted(
                zeroIndices.length,
                Arrays.stream(zeroIndices)
                    .map(oneIndex -> oneIndex + 1)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")))
        : "-1";
  }
}
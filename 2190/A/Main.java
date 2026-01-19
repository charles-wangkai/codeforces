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
    int oneCount = (int) s.chars().filter(c -> c == '1').count();
    int[] indices =
        IntStream.range(0, s.length())
            .filter(i -> s.charAt(i) == ((i >= s.length() - oneCount) ? '0' : '1'))
            .toArray();

    return (indices.length == 0)
        ? "Bob"
        : "Alice\n%d\n%s"
            .formatted(
                indices.length,
                Arrays.stream(indices)
                    .map(index -> index + 1)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
  }
}
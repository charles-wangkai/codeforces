import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int[] indices =
        IntStream.range(0, s.length())
            .filter(
                i -> (s.charAt(i) - s.charAt(0)) * (s.charAt(i) - s.charAt(s.length() - 1)) <= 0)
            .boxed()
            .sorted(Comparator.comparing(i -> Math.abs(s.charAt(i) - s.charAt(0))))
            .mapToInt(x -> x)
            .toArray();

    return String.format(
        "%d %d\n%s",
        Math.abs(s.charAt(0) - s.charAt(s.length() - 1)),
        indices.length,
        Arrays.stream(indices)
            .map(i -> i + 1)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" ")));
  }
}
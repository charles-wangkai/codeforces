import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextInt();
    String[] s = new String[n];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.next();
    }

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String[] s) {
    String[] flipped = Arrays.stream(s).map(Main::flipEven).toArray(String[]::new);

    return IntStream.range(0, s.length)
        .boxed()
        .sorted(Comparator.comparing(i -> flipped[i]))
        .map(i -> i + 1)
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static String flipEven(String x) {
    return IntStream.range(0, x.length())
        .mapToObj(i -> (char) ((i % 2 == 0) ? x.charAt(i) : ('A' + 'Z' - x.charAt(i))))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    int[] prefixBalances = new int[s.length()];
    for (int i = 1; i < prefixBalances.length; ++i) {
      prefixBalances[i] = prefixBalances[i - 1] + ((s.charAt(i - 1) == '(') ? 1 : -1);
    }

    return IntStream.range(0, s.length())
        .boxed()
        .sorted(
            Comparator.<Integer, Integer>comparing(i -> prefixBalances[i])
                .thenComparing(Comparator.<Integer, Integer>comparing(i -> i).reversed()))
        .map(i -> (char) s.charAt(i))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}
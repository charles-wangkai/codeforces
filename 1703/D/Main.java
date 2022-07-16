import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      String[] s = new String[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.next();
      }

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String[] s) {
    Set<String> set = Arrays.stream(s).collect(Collectors.toSet());

    return Arrays.stream(s)
        .map(
            si ->
                IntStream.range(1, si.length())
                        .anyMatch(
                            i -> set.contains(si.substring(0, i)) && set.contains(si.substring(i)))
                    ? "1"
                    : "0")
        .collect(Collectors.joining());
  }
}
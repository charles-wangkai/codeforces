import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] s = new int[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(int[] s) {
    int[] maxs =
        Arrays.stream(s)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .limit(2)
            .mapToInt(x -> x)
            .toArray();

    return Arrays.stream(s)
        .map(x -> x - ((x == maxs[0]) ? maxs[1] : maxs[0]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    int min = 0;
    int max = s.length();
    for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
      if (s.charAt(i) != s.charAt(j)) {
        ++min;
        --max;
      }
    }

    int[] result = new int[s.length() + 1];
    for (int i = min; i <= max; i += (s.length() % 2 == 0) ? 2 : 1) {
      result[i] = 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining());
  }
}

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
    int n = s.length() + 1;

    int[] result = new int[n];
    int min = 1;
    int max = n;
    for (int i = result.length - 1; i >= 1; --i) {
      if (s.charAt(i - 1) == '<') {
        result[i] = min;
        ++min;
      } else {
        result[i] = max;
        --max;
      }
    }
    result[0] = min;

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
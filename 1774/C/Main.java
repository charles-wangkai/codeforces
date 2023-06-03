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
    int[] result = new int[s.length()];
    int length = -1;
    for (int i = 0; i < result.length; ++i) {
      if (i != 0 && s.charAt(i) == s.charAt(i - 1)) {
        ++length;
      } else {
        length = 1;
      }

      result[i] = i + 2 - length;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}

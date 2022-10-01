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
    int min = Integer.MAX_VALUE;
    int[] counts = new int[10];
    for (int i = s.length() - 1; i >= 0; --i) {
      int digit = s.charAt(i) - '0';
      if (digit > min) {
        digit = Math.min(9, digit + 1);
      } else {
        min = Math.min(min, digit);
      }

      ++counts[digit];
    }

    return IntStream.range(0, counts.length)
        .mapToObj(i -> String.valueOf(i).repeat(counts[i]))
        .collect(Collectors.joining());
  }
}

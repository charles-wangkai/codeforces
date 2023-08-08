import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String x = sc.next();

      System.out.println(solve(x));
    }

    sc.close();
  }

  static String solve(String x) {
    int minIndex = Integer.MAX_VALUE;
    int carry = 0;
    for (int i = x.length() - 1; i >= 0; --i) {
      int sum = carry + (x.charAt(i) - '0');
      if (sum >= 5) {
        minIndex = i;
        carry = 1;
      } else {
        carry = 0;
      }
    }

    if (minIndex == Integer.MAX_VALUE) {
      return x;
    }

    int[] result = new int[x.length() + 1];
    carry = 1;
    for (int i = minIndex; i >= 0; --i) {
      int sum = carry + ((i == 0) ? 0 : (x.charAt(i - 1) - '0'));
      result[i] = sum % 10;
      carry = sum / 10;
    }

    return Arrays.stream(result)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining())
        .replaceAll("^0", "");
  }
}

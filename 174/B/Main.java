import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    int[] dp = new int[s.length() + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;

    for (int i = 1; i < dp.length; ++i) {
      for (int length = 1; length <= 12 && length <= i; ++length) {
        if (dp[i - length] != -1 && isValidName(s.substring(i - length, i))) {
          dp[i] = length;

          break;
        }
      }
    }

    if (dp[dp.length - 1] == -1) {
      return "NO";
    }

    List<String> partition = new ArrayList<>();
    int length = dp.length - 1;
    while (length != 0) {
      partition.add(s.substring(length - dp[length], length));
      length -= dp[length];
    }
    Collections.reverse(partition);

    return "YES\n%s".formatted(String.join("\n", partition));
  }

  static boolean isValidName(String name) {
    String[] fields = name.split("\\.", -1);

    return fields.length == 2
        && fields[0].length() >= 1
        && fields[0].length() <= 8
        && fields[1].length() >= 1
        && fields[1].length() <= 3;
  }
}
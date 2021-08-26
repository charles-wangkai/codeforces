import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(int n) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < 63; ++i) {
      String power = String.valueOf(1L << i);

      result = Math.min(result, computeMoveNum(String.valueOf(n), String.valueOf(power)));
    }

    return result;
  }

  static int computeMoveNum(String nStr, String power) {
    int result = nStr.length();
    int fromIndex = 0;
    for (int i = 0; i < power.length(); ++i) {
      int index = nStr.indexOf(power.charAt(i), fromIndex);
      if (index == -1) {
        result += power.length() - i;

        break;
      } else {
        --result;
        fromIndex = index + 1;
      }
    }

    return result;
  }
}

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int maxTwoCount = 1;
    int x = a.length;
    int y = 0;
    int beginIndex = 0;
    while (beginIndex != a.length) {
      if (a[beginIndex] == 0) {
        ++beginIndex;
      } else {
        int endIndex = beginIndex;
        while (endIndex != a.length - 1 && a[endIndex + 1] != 0) {
          ++endIndex;
        }

        {
          int twoCount = 1;
          int sign = 1;
          for (int i = beginIndex; i <= endIndex; ++i) {
            if (Math.abs(a[i]) == 2) {
              ++twoCount;
            }
            sign *= Integer.signum(a[i]);

            if (sign == 1 && twoCount > maxTwoCount) {
              maxTwoCount = twoCount;
              x = beginIndex;
              y = a.length - 1 - i;
            }
          }
        }

        {
          int twoCount = 1;
          int sign = 1;
          for (int i = endIndex; i >= beginIndex; --i) {
            if (Math.abs(a[i]) == 2) {
              ++twoCount;
            }
            sign *= Integer.signum(a[i]);

            if (sign == 1 && twoCount > maxTwoCount) {
              maxTwoCount = twoCount;
              x = i;
              y = a.length - 1 - endIndex;
            }
          }
        }

        beginIndex = endIndex + 1;
      }
    }

    return "%d %d".formatted(x, y);
  }
}
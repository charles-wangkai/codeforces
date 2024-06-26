import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int l = sc.nextInt();
      int r = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, l, r));
    }

    sc.close();
  }

  static int solve(int[] a, int l, int r) {
    int result = 0;
    int beginIndex = 0;
    int endIndex = -1;
    int sum = 0;
    while (beginIndex != a.length) {
      if (sum < l) {
        if (endIndex == a.length - 1) {
          break;
        }

        ++endIndex;
        sum += a[endIndex];
      } else if (sum > r) {
        sum -= a[beginIndex];
        ++beginIndex;
      } else {
        ++result;
        beginIndex = endIndex + 1;
        sum = 0;
      }
    }

    return result;
  }
}
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
    int beginIndex = 0;
    int endIndex = a.length - 1;
    int minValue = 1;
    int maxValue = a.length;
    while (beginIndex <= endIndex) {
      if (a[beginIndex] == minValue) {
        ++beginIndex;
        ++minValue;
      } else if (a[beginIndex] == maxValue) {
        ++beginIndex;
        --maxValue;
      } else if (a[endIndex] == minValue) {
        --endIndex;
        ++minValue;
      } else if (a[endIndex] == maxValue) {
        --endIndex;
        --maxValue;
      } else {
        return String.format("%d %d", beginIndex + 1, endIndex + 1);
      }
    }

    return "-1";
  }
}

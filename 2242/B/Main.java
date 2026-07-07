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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int index = 0;

    int leftLength = 0;
    int leftCount = 0;
    while (leftLength == 0
        || leftCount * 2 < leftLength
        || (index != a.length && a[index] == 3 && leftCount * 2 >= leftLength + 1)) {
      if (index == a.length) {
        return false;
      }

      ++leftLength;
      if (a[index] == 1) {
        ++leftCount;
      }
      ++index;
    }

    int middleLength = 0;
    int middleCount = 0;
    while (middleLength == 0 || middleCount * 2 < middleLength) {
      if (index == a.length) {
        return false;
      }

      ++middleLength;
      if (a[index] <= 2) {
        ++middleCount;
      }
      ++index;
    }

    return index != a.length;
  }
}
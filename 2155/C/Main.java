import java.util.Scanner;
import java.util.stream.IntStream;

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

  static int solve(int[] a) {
    return (check(a, true) ? 1 : 0) + (check(a, false) ? 1 : 0);
  }

  static boolean check(int[] a, boolean firstLeftOrRight) {
    boolean[] leftOrRights = new boolean[a.length];
    leftOrRights[0] = firstLeftOrRight;
    for (int i = 1; i < leftOrRights.length; ++i) {
      int diff = a[i] - a[i - 1];

      if (leftOrRights[i - 1]) {
        if (diff == 0) {
          leftOrRights[i] = false;
        } else if (diff == 1) {
          leftOrRights[i] = true;
        } else {
          return false;
        }
      } else if (diff == 0) {
        leftOrRights[i] = true;
      } else if (diff == -1) {
        leftOrRights[i] = false;
      } else {
        return false;
      }
    }

    return 1 + (int) IntStream.range(1, leftOrRights.length).filter(i -> !leftOrRights[i]).count()
        == a[0];
  }
}
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

  static int solve(int[] a) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; ; ++i) {
      int operationNum = i;
      int[] modified = a.clone();
      boolean possible = true;
      for (int j = modified.length - 2; j >= 0; --j) {
        while (modified[j] >= modified[j + 1]) {
          if (modified[j] == 0) {
            possible = false;

            break;
          }

          modified[j] /= 2;
          ++operationNum;
        }
        if (!possible) {
          break;
        }
      }

      if (!possible) {
        break;
      }

      result = Math.min(result, operationNum);

      if (a[a.length - 1] == 0) {
        break;
      }

      a[a.length - 1] /= 2;
    }

    return (result == Integer.MAX_VALUE) ? -1 : result;
  }
}
import java.util.Arrays;
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
    return (Arrays.stream(a).sum() % 2 == 0)
        ? 0
        : Arrays.stream(a)
            .map(
                x -> {
                  int current = x;
                  for (int i = 0; x != 0; ++i) {
                    if (current % 2 != x % 2) {
                      return i;
                    }
                    current /= 2;
                  }

                  return Integer.MAX_VALUE;
                })
            .min()
            .getAsInt();
  }
}

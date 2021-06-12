import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    long[] maxHealths = new long[a.length + 1];
    Arrays.fill(maxHealths, -1);
    maxHealths[0] = 0;

    for (int ai : a) {
      for (int i = maxHealths.length - 2; i >= 0; --i) {
        if (maxHealths[i] != -1 && maxHealths[i] + ai >= 0) {
          maxHealths[i + 1] = Math.max(maxHealths[i + 1], maxHealths[i] + ai);
        }
      }
    }

    return IntStream.range(0, maxHealths.length).filter(i -> maxHealths[i] != -1).max().getAsInt();
  }
}

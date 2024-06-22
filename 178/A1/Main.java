import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  static String solve(int[] a) {
    int[] result = new int[a.length - 1];
    for (int i = 0; i < result.length; ++i) {
      int t = 0;
      while (i + (1 << (t + 1)) < a.length) {
        ++t;
      }

      result[i] = ((i == 0) ? 0 : result[i - 1]) + a[i];
      a[i + (1 << t)] += a[i];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}
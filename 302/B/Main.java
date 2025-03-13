import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] c = new int[n];
    int[] t = new int[n];
    for (int i = 0; i < n; ++i) {
      c[i] = sc.nextInt();
      t[i] = sc.nextInt();
    }
    int[] v = new int[m];
    for (int i = 0; i < v.length; ++i) {
      v[i] = sc.nextInt();
    }

    System.out.println(solve(c, t, v));

    sc.close();
  }

  static String solve(int[] c, int[] t, int[] v) {
    int[] result = new int[v.length];
    int index = -1;
    int maxTime = 0;
    for (int i = 0; i < result.length; ++i) {
      while (v[i] > maxTime) {
        ++index;
        maxTime += c[index] * t[index];
      }

      result[i] = index + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x));
    }

    sc.close();
  }

  static String solve(int[] x) {
    int[] y = new int[x.length];
    int xor = x[0];
    for (int i = 1; i < y.length; ++i) {
      xor |= x[i];
      y[i] = xor ^ x[i];
    }

    return Arrays.stream(y).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}

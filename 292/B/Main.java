import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] x = new int[m];
    int[] y = new int[m];
    for (int i = 0; i < m; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(n, x, y));

    sc.close();
  }

  static String solve(int n, int[] x, int[] y) {
    int[] degrees = new int[n];
    for (int i = 0; i < x.length; ++i) {
      ++degrees[x[i] - 1];
      ++degrees[y[i] - 1];
    }

    if (x.length == n - 1 && Arrays.stream(degrees).filter(degree -> degree == 1).count() == 2) {
      return "bus topology";
    }
    if (Arrays.stream(degrees).allMatch(degree -> degree == 2)) {
      return "ring topology";
    }
    if (Arrays.stream(degrees).filter(degree -> degree == 1).count() == n - 1) {
      return "star topology";
    }

    return "unknown topology";
  }
}
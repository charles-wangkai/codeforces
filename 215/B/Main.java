import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    int[] y = new int[m];
    for (int i = 0; i < y.length; ++i) {
      y[i] = sc.nextInt();
    }
    int k = sc.nextInt();
    int[] z = new int[k];
    for (int i = 0; i < z.length; ++i) {
      z[i] = sc.nextInt();
    }
    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println("%.9f".formatted(solve(x, y, z, A, B)));

    sc.close();
  }

  static double solve(int[] x, int[] y, int[] z, int A, int B) {
    int r1 = Arrays.stream(x).max().getAsInt();
    int p1 = Arrays.stream(y).max().getAsInt();
    int p2 = Arrays.stream(z).min().getAsInt();

    return Math.sqrt((double) B * p1 / (A * p2 + B * p1) * r1 * r1);
  }
}
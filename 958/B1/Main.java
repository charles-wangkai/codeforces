import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] u = new int[N - 1];
    int[] v = new int[N - 1];
    for (int i = 0; i < N - 1; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(u, v));

    sc.close();
  }

  static int solve(int[] u, int[] v) {
    int N = u.length + 1;

    int[] degrees = new int[N];
    for (int i = 0; i < u.length; ++i) {
      ++degrees[u[i] - 1];
      ++degrees[v[i] - 1];
    }

    return (int) Arrays.stream(degrees).filter(degree -> degree == 1).count();
  }
}
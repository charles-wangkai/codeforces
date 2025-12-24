import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] m = new int[n];
    for (int i = 0; i < m.length; ++i) {
      m[i] = sc.nextInt();
    }

    System.out.println(solve(m));

    sc.close();
  }

  static int solve(int[] m) {
    int lowerTarget = Arrays.stream(m).sum() / m.length;
    int upperTarget = Math.ceilDiv(Arrays.stream(m).sum(), m.length);

    return Math.max(
        Arrays.stream(m).map(mi -> Math.max(0, lowerTarget - mi)).sum(),
        Arrays.stream(m).map(mi -> Math.max(0, mi - upperTarget)).sum());
  }
}
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int P1 = sc.nextInt();
    int P2 = sc.nextInt();
    int P3 = sc.nextInt();
    int T1 = sc.nextInt();
    int T2 = sc.nextInt();
    int[] l = new int[n];
    int[] r = new int[n];
    for (int i = 0; i < n; ++i) {
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    System.out.println(solve(l, r, P1, P2, P3, T1, T2));

    sc.close();
  }

  static int solve(int[] l, int[] r, int P1, int P2, int P3, int T1, int T2) {
    return IntStream.range(0, l.length).map(i -> (r[i] - l[i]) * P1).sum()
        + IntStream.range(0, l.length - 1)
            .map(i -> computePower(P1, P2, P3, T1, T2, l[i + 1] - r[i]))
            .sum();
  }

  static int computePower(int P1, int P2, int P3, int T1, int T2, int time) {
    int time1 = Math.min(time, T1);
    int time2 = Math.min(time - time1, T2);
    int time3 = time - time1 - time2;

    return time1 * P1 + time2 * P2 + time3 * P3;
  }
}
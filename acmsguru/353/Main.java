import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int k1 = sc.nextInt();
    int k2 = sc.nextInt();
    int p1 = sc.nextInt();
    int p2 = sc.nextInt();
    int p3 = sc.nextInt();

    System.out.println(solve(N, k1, k2, p1, p2, p3));

    sc.close();
  }

  static int solve(int N, int k1, int k2, int p1, int p2, int p3) {
    if (N < p1) {
      return 0;
    }
    if (N == p1) {
      return k1;
    }

    int result = -1;
    int lower = 1;
    int upper = 10_000_000;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(N, k1, k2, p1, p2, p3, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int N, int k1, int k2, int p1, int p2, int p3, int time) {
    long cost = p1;
    time = Math.max(0, time - k1);

    cost += (long) Math.min(k2, time) * p2;
    time = Math.max(0, time - k2);

    cost += (long) time * p3;

    return cost >= N;
  }
}

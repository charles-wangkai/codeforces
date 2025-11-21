import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }

    System.out.println(solve(x, k));

    sc.close();
  }

  static int solve(int[] x, int k) {
    if (IntStream.range(0, x.length - 1).anyMatch(i -> x[i + 1] - x[i] > k)) {
      return -1;
    }

    int result = 1;
    int begin = x[0];
    for (int i = 1; i < x.length; ++i) {
      if (x[i] - begin > k) {
        begin = x[i - 1];
        ++result;
      }
    }

    return result;
  }
}
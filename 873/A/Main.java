import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int x = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k, x));

    sc.close();
  }

  static int solve(int[] a, int k, int x) {
    return IntStream.range(0, a.length - k).map(i -> a[i]).sum() + k * x;
  }
}
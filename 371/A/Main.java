import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static int solve(int[] a, int k) {
    return IntStream.range(0, k)
        .map(
            i -> {
              int count1 =
                  (int) IntStream.range(0, a.length / k).filter(j -> a[j * k + i] == 1).count();

              return Math.min(count1, a.length / k - count1);
            })
        .sum();
  }
}
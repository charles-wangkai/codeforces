import java.util.Arrays;
import java.util.Comparator;
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
    for (int i = 0; i < a.length; ++i) {
      if (a[i] < 0 && k != 0) {
        a[i] *= -1;
        --k;
      }
    }

    if (k % 2 == 1) {
      int index = IntStream.range(0, a.length).boxed().min(Comparator.comparing(i -> a[i])).get();
      a[index] *= -1;
    }

    return Arrays.stream(a).sum();
  }
}

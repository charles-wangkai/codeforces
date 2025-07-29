import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[n];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    return Arrays.equals(normalize(a), normalize(b));
  }

  static int[] normalize(int[] values) {
    int oneIndex =
        IntStream.range(0, values.length).filter(i -> values[i] == 1).findAny().getAsInt();

    return IntStream.range(0, values.length)
        .map(i -> values[(oneIndex + i) % values.length])
        .filter(x -> x != 0)
        .toArray();
  }
}
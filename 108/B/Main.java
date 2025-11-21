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

    System.out.println(solve(a) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int[] a) {
    int[] sorted = Arrays.stream(a).sorted().distinct().toArray();

    return IntStream.range(0, sorted.length - 1).anyMatch(i -> sorted[i + 1] < sorted[i] * 2);
  }
}
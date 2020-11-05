import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, x) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b, int x) {
    int[] sortedA = Arrays.stream(a).boxed().sorted().mapToInt(y -> y).toArray();
    int[] sortedB =
        Arrays.stream(b).boxed().sorted(Collections.reverseOrder()).mapToInt(y -> y).toArray();

    return IntStream.range(0, sortedA.length).allMatch(i -> sortedA[i] + sortedB[i] <= x);
  }
}

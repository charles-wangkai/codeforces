import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int s = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[n];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, s) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int[] a, int[] b, int s) {
    return a[0] == 1
        && (a[s - 1] == 1
            || (b[s - 1] == 1
                && IntStream.range(s, a.length).anyMatch(i -> a[i] == 1 && b[i] == 1)));
  }
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[] a) {
    int min = Arrays.stream(a).min().getAsInt();
    int max = Arrays.stream(a).max().getAsInt();

    return (min == max)
        ? ((long) a.length * a.length - a.length)
        : (Arrays.stream(a).filter(x -> x == min).count()
            * Arrays.stream(a).filter(x -> x == max).count()
            * 2);
  }
}

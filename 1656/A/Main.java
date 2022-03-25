import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

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

  static String solve(int[] a) {
    int min = Arrays.stream(a).min().getAsInt();
    int indexWithMin = IntStream.range(0, a.length).filter(i -> a[i] == min).findAny().getAsInt();
    int max = Arrays.stream(a).max().getAsInt();
    int indexWithMax = IntStream.range(0, a.length).filter(i -> a[i] == max).findAny().getAsInt();

    return String.format("%d %d", indexWithMin + 1, indexWithMax + 1);
  }
}
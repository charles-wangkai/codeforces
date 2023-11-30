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

  static int solve(int[] a) {
    int min = Arrays.stream(a).min().getAsInt();
    int index = IntStream.range(0, a.length).filter(i -> a[i] == min).findFirst().getAsInt();

    return IntStream.range(index, a.length - 1).allMatch(i -> a[i] <= a[i + 1]) ? index : -1;
  }
}
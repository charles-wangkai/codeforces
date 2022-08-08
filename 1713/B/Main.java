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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int max = Arrays.stream(a).max().getAsInt();
    int middleIndex = IntStream.range(0, a.length).filter(i -> a[i] == max).findAny().getAsInt();

    return IntStream.range(0, middleIndex).allMatch(i -> a[i] <= a[i + 1])
        && IntStream.range(middleIndex, a.length - 1).allMatch(i -> a[i] >= a[i + 1]);
  }
}
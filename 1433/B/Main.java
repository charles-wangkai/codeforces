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
    int minOneIndex = IntStream.range(0, a.length).filter(i -> a[i] == 1).min().getAsInt();
    int maxOneIndex = IntStream.range(0, a.length).filter(i -> a[i] == 1).max().getAsInt();

    return (int) IntStream.rangeClosed(minOneIndex, maxOneIndex).filter(i -> a[i] == 0).count();
  }
}

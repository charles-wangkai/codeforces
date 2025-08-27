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

  static long solve(int[] a) {
    int[] modified = a.clone();

    for (int i = 1; i < modified.length; i += 2) {
      modified[i - 1] = Math.min(modified[i - 1], modified[i]);

      if (i != modified.length - 1) {
        modified[i + 1] = Math.min(modified[i + 1], modified[i] - modified[i - 1]);
      }
    }

    return IntStream.range(0, a.length).map(i -> a[i] - modified[i]).asLongStream().sum();
  }
}
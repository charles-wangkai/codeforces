import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x, y));
    }

    sc.close();
  }

  static long solve(int[] a, int x, int y) {
    int[] transferNums = Arrays.stream(a).map(ai -> ai / x).toArray();
    long transferNumSum = Arrays.stream(transferNums).asLongStream().sum();

    return IntStream.range(0, a.length)
        .mapToLong(i -> a[i] + (transferNumSum - transferNums[i]) * y)
        .max()
        .getAsLong();
  }
}
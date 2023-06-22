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
    int[] nonZeros = Arrays.stream(a).filter(x -> x != 0).toArray();

    return String.format(
        "%d %d",
        Arrays.stream(a).map(Math::abs).asLongStream().sum(),
        IntStream.range(0, nonZeros.length)
            .filter(i -> nonZeros[i] < 0 && (i == 0 || nonZeros[i - 1] > 0))
            .count());
  }
}

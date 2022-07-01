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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    long sum = Arrays.stream(a).asLongStream().sum();
    if (a.length == 3) {
      return Arrays.stream(a).anyMatch(ai -> ai == sum);
    }
    if (a.length == 4) {
      return Arrays.stream(a).allMatch(ai -> Arrays.stream(a).anyMatch(x -> x == sum - ai));
    }

    int[] nonZeros = Arrays.stream(a).filter(ai -> ai != 0).toArray();

    return nonZeros.length <= 1 || (nonZeros.length == 2 && nonZeros[0] == -nonZeros[1]);
  }
}
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
    int[] evens = Arrays.stream(a).filter(ai -> ai % 2 == 0).sorted().toArray();
    int[] odds = Arrays.stream(a).filter(ai -> ai % 2 == 1).sorted().toArray();
    if (evens.length == 0) {
      return odds[odds.length - 1];
    }
    if (odds.length == 0) {
      return evens[evens.length - 1];
    }

    return Arrays.stream(a).asLongStream().sum() - (odds.length - 1);
  }
}
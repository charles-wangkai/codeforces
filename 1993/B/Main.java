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

  static int solve(int[] a) {
    if (Arrays.stream(a).map(ai -> ai % 2).distinct().count() == 1) {
      return 0;
    }

    long maxOdd = Arrays.stream(a).filter(ai -> ai % 2 == 1).max().getAsInt();
    int[] evens = Arrays.stream(a).filter(ai -> ai % 2 == 0).sorted().toArray();
    int result = evens.length;
    for (int even : evens) {
      if (even > maxOdd) {
        maxOdd += evens[evens.length - 1];
        ++result;
      }

      maxOdd += even;
    }

    return result;
  }
}
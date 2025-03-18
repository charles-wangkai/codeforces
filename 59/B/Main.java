import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    int[] odds = Arrays.stream(a).filter(x -> x % 2 == 1).sorted().toArray();
    if (odds.length == 0) {
      return 0;
    }

    return (Arrays.stream(odds).sum() - ((odds.length % 2 == 0) ? odds[0] : 0))
        + Arrays.stream(a).filter(x -> x % 2 == 0).sum();
  }
}
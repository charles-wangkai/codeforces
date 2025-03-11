import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  static String solve(int[] a) {
    List<Integer> added = new ArrayList<>();
    for (int i = 0; i < a.length; ++i) {
      added.add(a[i]);
      if (i != a.length - 1 && gcd(a[i], a[i + 1]) != 1) {
        added.add(1);
      }
    }

    return "%d\n%s"
        .formatted(
            added.size() - a.length,
            added.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
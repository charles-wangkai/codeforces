import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    int max = Arrays.stream(a).max().getAsInt();
    int[] b = Arrays.stream(a).filter(x -> x != max).toArray();
    int[] c = Arrays.stream(a).filter(x -> x == max).toArray();

    return (b.length == 0)
        ? "-1"
        : String.format(
            "%d %d\n%s\n%s",
            b.length,
            c.length,
            Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" ")),
            Arrays.stream(c).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}

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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int[] values = Arrays.stream(a).boxed().sorted().distinct().mapToInt(x -> x).toArray();

    return values.length == 1
        || values[0] >= 2
        || (values[0] == 0 && values[1] >= 2)
        || !((values[0] == 0 && values[1] == 1)
            || IntStream.range(0, values.length - 1).anyMatch(i -> values[i] + 1 == values[i + 1]));
  }
}
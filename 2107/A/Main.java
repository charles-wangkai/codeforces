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
    if (Arrays.stream(a).distinct().count() == 1) {
      return "No";
    }

    int max = Arrays.stream(a).max().getAsInt();

    return "Yes\n%s"
        .formatted(
            Arrays.stream(a)
                .map(ai -> (ai == max) ? 1 : 2)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}
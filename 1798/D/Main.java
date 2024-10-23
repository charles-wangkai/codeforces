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
    Arrays.sort(a);
    if (a[0] == 0) {
      return "No";
    }

    int[] rearranged = new int[a.length];
    int beginIndex = 0;
    int endIndex = a.length - 1;
    int sum = 0;
    for (int i = 0; i < rearranged.length; ++i) {
      if (sum >= 0) {
        rearranged[i] = a[beginIndex];
        ++beginIndex;
      } else {
        rearranged[i] = a[endIndex];
        --endIndex;
      }

      sum += rearranged[i];
    }

    return "Yes\n%s"
        .formatted(
            Arrays.stream(rearranged).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
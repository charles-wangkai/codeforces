import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static String solve(int[] a, int k) {
    Arrays.sort(a);

    Set<Integer> values = Arrays.stream(a).boxed().collect(Collectors.toSet());

    List<Integer> set = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();
    for (int ai : a) {
      if (!seen.contains(ai)) {
        for (int multiple = ai; multiple <= k; multiple += ai) {
          if (!values.contains(multiple)) {
            return "-1";
          }

          seen.add(multiple);
        }

        set.add(ai);
      }
    }

    return "%d\n%s"
        .formatted(set.size(), set.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}
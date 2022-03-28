import java.util.Arrays;
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

      System.out.println(solve(a, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int k) {
    Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());

    return Arrays.stream(a).anyMatch(ai -> set.contains(ai + k));
  }
}
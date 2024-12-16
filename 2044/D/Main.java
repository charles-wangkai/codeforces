import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
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
    int[] result = new int[a.length];
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < result.length; ++i) {
      if (!seen.contains(a[i])) {
        result[i] = a[i];
        seen.add(a[i]);
      }
    }
    int value = 1;
    for (int i = 0; i < result.length; ++i) {
      if (result[i] == 0) {
        while (seen.contains(value)) {
          ++value;
        }

        result[i] = value;
        ++value;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
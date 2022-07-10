import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    int[] permutation = new int[n];
    int index = 0;
    boolean[] used = new boolean[n + 1];
    for (int i = 1; i < used.length; ++i) {
      for (int j = i; j < used.length; j *= 2) {
        if (!used[j]) {
          used[j] = true;
          permutation[index] = j;
          ++index;
        }
      }
    }

    return String.format(
        "2\n%s",
        Arrays.stream(permutation).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
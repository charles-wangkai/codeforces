import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, int k) {
    int[] result = new int[n];

    int lower = 1;
    for (int i = 0; i < k; i += 2) {
      for (int j = i; j < result.length; j += k) {
        result[j] = lower;
        ++lower;
      }
    }

    int upper = n;
    for (int i = 1; i < 1 + k; i += 2) {
      for (int j = i; j < result.length; j += k) {
        result[j] = upper;
        --upper;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
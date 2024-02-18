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
    int[] result = new int[n];
    int lower = 1;
    int upper = n;
    for (int i = 0; i < result.length; ++i) {
      if (i % 2 == 0) {
        result[i] = lower;
        ++lower;
      } else {
        result[i] = upper;
        --upper;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
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
    int[] result = new int[2 * n];
    result[0] = n;
    result[n] = n;
    for (int i = n - 1, leftIndex = 1, rightIndex = result.length - 1;
        i >= 1;
        --i, ++leftIndex, --rightIndex) {
      result[leftIndex] = i;
      result[rightIndex] = i;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
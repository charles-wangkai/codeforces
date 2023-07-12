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
    int posLength = 0;
    while ((posLength + 1) * (posLength + 2) / 2 <= k) {
      ++posLength;
    }

    int[] result = new int[n];
    for (int i = 0; i < posLength; ++i) {
      result[i] = 2;
    }
    if (posLength != result.length) {
      result[posLength] = -(posLength * 2 + 1 - 2 * (k - posLength * (posLength + 1) / 2));
    }
    for (int i = posLength + 1; i < result.length; ++i) {
      result[i] = -1000;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}

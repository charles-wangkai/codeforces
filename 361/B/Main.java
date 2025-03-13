import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static String solve(int n, int k) {
    if (k == n) {
      return "-1";
    }

    int[] result = new int[n];
    for (int i = 0; i < n - k - 1; ++i) {
      result[i] = i + 2;
    }
    result[n - k - 1] = 1;
    for (int i = n - k; i < result.length; ++i) {
      result[i] = i + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
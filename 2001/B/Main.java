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
    if (n % 2 == 0) {
      return "-1";
    }

    int[] result = new int[n];
    for (int i = 0; i < n / 2 + 1; ++i) {
      result[i] = n / 2 + 1 - i;
    }
    for (int i = n / 2 + 1; i < n; ++i) {
      result[i] = i + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
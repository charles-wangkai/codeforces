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
    int[] result = new int[n * 3];
    for (int i = 0; i < n; ++i) {
      result[i * 3] = i + 1;
    }

    int index = 0;
    for (int i = n + 1; i <= 3 * n; ++i) {
      while (result[index] != 0) {
        ++index;
      }

      result[index] = i;
      ++index;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
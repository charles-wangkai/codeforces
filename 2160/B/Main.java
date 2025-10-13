import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long[] b = new long[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextLong();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(long[] b) {
    int[] result = new int[b.length];
    int value = 1;
    for (int i = 0; i < result.length; ++i) {
      int diff = (int) (b[i] - ((i == 0) ? 0 : b[i - 1]));
      if (diff == i + 1) {
        result[i] = value;
        ++value;
      } else {
        result[i] = result[i - diff];
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(int[] b) {
    int[] result = new int[b.length];
    int leftIndex = 0;
    int rightIndex = b.length - 1;
    for (int i = 0; i < result.length; ++i) {
      if (i % 2 == 0) {
        result[i] = b[leftIndex];
        ++leftIndex;
      } else {
        result[i] = b[rightIndex];
        --rightIndex;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}

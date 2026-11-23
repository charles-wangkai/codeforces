import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int t = sc.nextInt();
      for (int tc = 0; tc < t; ++tc) {
        int n = sc.nextInt();

        System.out.println(solve(n));
      }
    }
  }

  static String solve(int n) {
    if (n < 4) {
      return "-1";
    }

    int[] result = IntStream.rangeClosed(1, n).toArray();
    result[0] = 4;
    result[3] = 1;

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
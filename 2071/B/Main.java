import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    int[] result = IntStream.range(0, n).map(i -> i + 1).toArray();
    long sum = 0;
    for (int i = 0; i < result.length; ++i) {
      if (isSquare(sum + result[i])) {
        if (i == result.length - 1) {
          return "-1";
        }

        int temp = result[i];
        result[i] = result[i + 1];
        result[i + 1] = temp;
      }

      sum += result[i];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static boolean isSquare(long x) {
    int root = (int) Math.round(Math.sqrt(x));

    return (long) root * root == x;
  }
}
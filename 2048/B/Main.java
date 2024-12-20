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
    int[] result = new int[n];
    int value = 1;
    int index = k - 1;
    while (index < result.length) {
      result[index] = value;
      ++value;
      if (index == result.length - 1) {
        break;
      }

      index = Math.min(result.length - 1, index + k);
    }
    for (int i = 0; i < result.length; ++i) {
      if (result[i] == 0) {
        result[i] = value;
        ++value;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
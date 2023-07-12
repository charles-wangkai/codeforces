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
    int[] result = new int[n];
    result[result.length - 1] = 3;
    result[0] = 2;
    result[result.length / 2] = 1;

    int value = 4;
    for (int i = 0; i < result.length; ++i) {
      if (result[i] == 0) {
        result[i] = value;
        ++value;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}

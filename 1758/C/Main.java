import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();

      System.out.println(solve(n, x));
    }

    sc.close();
  }

  static String solve(int n, int x) {
    if (n % x != 0) {
      return "-1";
    }

    int[] result = new int[n];
    result[0] = x;
    result[result.length - 1] = 1;
    for (int i = 1; i < result.length - 1; ++i) {
      result[i] = i + 1;
    }

    int rest = n / x;
    int product = x;
    for (int i = 2; i * i <= rest; ++i) {
      while (rest % i == 0) {
        result[product - 1] = product * i;

        product *= i;
        rest /= i;
      }
    }
    if (rest != 1) {
      result[product - 1] = product * rest;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}

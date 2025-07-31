import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt();

    System.out.println(solve(k));

    sc.close();
  }

  static String solve(int k) {
    String[][] result = new String[k - 1][k - 1];
    for (int i = 0; i < k - 1; ++i) {
      for (int j = 0; j < k - 1; ++j) {
        result[i][j] = multiply(k, i + 1, j + 1);
      }
    }

    return Arrays.stream(result)
        .map(line -> String.join(" ", line))
        .collect(Collectors.joining("\n"));
  }

  static String multiply(int k, int x, int y) {
    String result = "";
    int rest = x * y;
    while (rest != 0) {
      result = String.valueOf(rest % k) + result;
      rest /= k;
    }

    return result;
  }
}
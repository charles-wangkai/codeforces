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
    if (n == 3) {
      return "1 3 2";
    }

    int[] result = new int[n];
    int half = n / 2;
    for (int i = 0; i < half; ++i) {
      result[i * 2] = i + 1;
      result[i * 2 + 1] = i + 1 + (1 << 30);
    }
    if (half % 2 == 1) {
      result[1] += 1 << 29;
      result[3] += -(1 << 30) + (1 << 29);
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
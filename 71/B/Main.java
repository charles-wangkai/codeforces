import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int t = sc.nextInt();

    System.out.println(solve(n, k, t));

    sc.close();
  }

  static String solve(int n, int k, int t) {
    int rest = n * k * t / 100;
    int[] result = new int[n];
    for (int i = 0; i < result.length; ++i) {
      result[i] = Math.min(k, rest);
      rest -= result[i];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
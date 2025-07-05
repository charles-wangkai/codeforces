import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    System.out.println(solve(n, m));

    sc.close();
  }

  static String solve(int n, int m) {
    int[] result = new int[n];
    boolean leftOrRight = false;
    int left = -1;
    int right = -1;
    for (int i = 0; i < result.length; ++i) {
      if (i % m == 0) {
        leftOrRight = m % 2 == 0;
        left = m / 2;
        right = left + 1;
      }

      if (leftOrRight) {
        result[i] = left;
        --left;
      } else {
        result[i] = right;
        ++right;
      }
      leftOrRight ^= true;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(n, a, b));

    sc.close();
  }

  static String solve(int n, int a, int b) {
    if (n > a * b) {
      return "-1";
    }

    int[][] result = new int[a][b];
    int odd = 1;
    int even = 2;
    for (int r = 0; r < a; ++r) {
      for (int c = 0; c < b; ++c) {
        if ((r + c) % 2 == 0) {
          if (odd <= n) {
            result[r][c] = odd;
            odd += 2;
          }
        } else if (even <= n) {
          result[r][c] = even;
          even += 2;
        }
      }
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}
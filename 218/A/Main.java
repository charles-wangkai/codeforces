import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] r = new int[2 * n + 1];
    for (int i = 0; i < r.length; ++i) {
      r[i] = sc.nextInt();
    }

    System.out.println(solve(r, k));

    sc.close();
  }

  static String solve(int[] r, int k) {
    for (int i = 1; i < r.length; i += 2) {
      if (k != 0 && r[i] - 1 > Math.max(r[i - 1], r[i + 1])) {
        --r[i];
        --k;
      }
    }

    return Arrays.stream(r).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
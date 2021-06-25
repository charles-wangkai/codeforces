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
    int oneCount = k - 3;
    int sum = n - oneCount;

    int a1;
    int a2;
    int a3;
    if (sum % 2 != 0) {
      a1 = 1;
      a2 = (sum - 1) / 2;
      a3 = (sum - 1) / 2;
    } else if (sum % 4 == 0) {
      a1 = sum / 2;
      a2 = sum / 4;
      a3 = sum / 4;
    } else {
      a1 = 2;
      a2 = (sum - 2) / 2;
      a3 = (sum - 2) / 2;
    }

    int[] result = new int[k];
    Arrays.fill(result, 1);
    result[0] = a1;
    result[1] = a2;
    result[2] = a3;

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}

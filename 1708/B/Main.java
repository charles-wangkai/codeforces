import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int l = sc.nextInt();
      int r = sc.nextInt();

      System.out.println(solve(n, l, r));
    }

    sc.close();
  }

  static String solve(int n, int l, int r) {
    int[] result = new int[n];
    for (int i = 0; i < result.length; ++i) {
      result[i] = r / (i + 1) * (i + 1);
      if (result[i] < l) {
        return "NO";
      }
    }

    return String.format(
        "YES\n%s",
        Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
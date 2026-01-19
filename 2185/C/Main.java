import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int[] values = Arrays.stream(a).sorted().distinct().toArray();

    int result = 1;
    int length = 1;
    for (int i = 1; i < values.length; ++i) {
      if (values[i] == values[i - 1] + 1) {
        ++length;
        result = Math.max(result, length);
      } else {
        length = 1;
      }
    }

    return result;
  }
}
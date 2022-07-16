import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  static String solve(int[] a) {
    int[] result = new int[a.length];
    for (int i = result.length - 1; i >= 0; --i) {
      int index = 0;
      while (a[index] != i + 1) {
        ++index;
      }

      result[i] = (index + 1) % (i + 1);

      reverse(a, 0, index);
      reverse(a, index + 1, i);
      reverse(a, 0, i);
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void reverse(int[] a, int beginIndex, int endIndex) {
    for (int i = beginIndex, j = endIndex; i < j; ++i, --j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }
}
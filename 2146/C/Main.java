import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int[] p = IntStream.rangeClosed(1, s.length()).toArray();
    int beginIndex = 0;
    for (int i = 0; i <= p.length; ++i) {
      if (i == p.length || s.charAt(i) == '1') {
        if (i - beginIndex == 1) {
          return "NO";
        }

        reverse(p, beginIndex, i - 1);

        beginIndex = i + 1;
      }
    }

    return "YES\n%s"
        .formatted(Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }

  static void reverse(int[] a, int beginIndex, int endIndex) {
    for (int i = beginIndex, j = endIndex; i < j; ++i, --j) {
      swap(a, i, j);
    }
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }
}
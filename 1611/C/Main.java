import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    if (a.length == 1) {
      return "1";
    }

    int beginIndex;
    int endIndex;
    if (a[0] == a.length) {
      beginIndex = 1;
      endIndex = a.length - 1;
    } else if (a[a.length - 1] == a.length) {
      beginIndex = 0;
      endIndex = a.length - 2;
    } else {
      return "-1";
    }

    return String.format(
        "%d %s",
        a.length,
        IntStream.rangeClosed(beginIndex, endIndex)
            .mapToObj(i -> String.valueOf(a[beginIndex + endIndex - i]))
            .collect(Collectors.joining(" ")));
  }
}

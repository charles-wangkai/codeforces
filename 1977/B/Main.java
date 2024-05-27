import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int LIMIT = 32;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();

      System.out.println(solve(x));
    }

    sc.close();
  }

  static String solve(int x) {
    int[] a = new int[LIMIT];
    for (int i = 0; i < a.length; ++i) {
      if (((x >> i) & 1) == 1) {
        a[i] = 1;
      }
    }
    for (int i = 0; i < a.length - 1; ++i) {
      if (a[i] == 1 && a[i + 1] == 1) {
        a[i] = -1;

        int index = i + 1;
        while (a[index] == 1) {
          a[index] = 0;

          ++index;
        }
        a[index] = 1;
      }
    }

    return String.format(
        "%d\n%s",
        a.length, Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}